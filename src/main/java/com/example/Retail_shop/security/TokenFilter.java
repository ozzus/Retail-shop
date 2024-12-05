package com.example.Retail_shop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;

import java.io.*;
@Component
@Slf4j
public class TokenFilter  extends OncePerRequestFilter {
    @Autowired
    private JwtCore jwtCore;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = null;
        String userEmail = null;
        UserDetails userDetails = null;
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwt = authHeader.substring(7);
            }
            if (jwt != null) {
                try {
                    userEmail = jwtCore.getNameFromJwt(jwt);
                } catch (ExpiredJwtException e) {

                }
                if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    userDetails = userDetailsService.loadUserByUsername(userEmail);
                    authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    log.info("Проверка токена: {}", jwt);
                    log.info("Имя пользователя из токена: {}", userEmail);
                    log.info("Роли пользователя: {}", userDetails.getAuthorities());
                }
            }
        } catch (Exception e) {
        }
        filterChain.doFilter(request, response);
    }
}
