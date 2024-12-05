package com.example.Retail_shop.security;

import com.example.Retail_shop.models.Users;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;

@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private long userId;
    private String userName;
    private String userPasswordHash;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    public static UserDetailsImpl build(Users user) {
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUserName(),
                user.getUserPasswordHash(),
                user.getUserEmail(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getUserPassword()
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
