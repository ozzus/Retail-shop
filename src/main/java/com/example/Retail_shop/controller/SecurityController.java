package com.example.Retail_shop.controller;

import com.example.Retail_shop.RetailShopApplication;
import com.example.Retail_shop.dal.DataAccessLayer;
import com.example.Retail_shop.dto.SigninRequest;
import com.example.Retail_shop.dto.SignupRequest;
import com.example.Retail_shop.models.Users;
import com.example.Retail_shop.security.JwtCore;
import com.example.Retail_shop.security.UserDetailsImpl;
import com.example.Retail_shop.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/auth")
public class SecurityController {
    private AuthenticationManager authenticationManager;
    private DataAccessLayer dataAccessLayer;
    private PasswordEncoder passwordEncoder;
    private JwtCore jwtCore;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setDataAccessLayer(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    @Autowired
    public void setJwtCore(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        if (dataAccessLayer.existsUsersByUserEmail(signupRequest.getUserEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        Users user = new Users();
        user.setUserName(signupRequest.getUserName());
        user.setUserPasswordHash(signupRequest.getUserPasswordHash());
        user.setUserEmail(signupRequest.getUserEmail());
        user.setUserFirstName(signupRequest.getUserFirstName());
        user.setUserLastName(signupRequest.getUserLastName());
        user.setUserPassword(passwordEncoder.encode(signupRequest.getUserPassword()));
        dataAccessLayer.createUsers(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUserEmail(), signinRequest.getUserPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(jwt);
    }
}
