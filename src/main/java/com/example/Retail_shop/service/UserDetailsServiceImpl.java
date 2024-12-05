package com.example.Retail_shop.service;
import com.example.Retail_shop.dal.DataAccessLayer;
import com.example.Retail_shop.dto.SignupRequest;
import com.example.Retail_shop.models.Users;
import com.example.Retail_shop.repositories.UserRepository;
import com.example.Retail_shop.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Users users = dataAccessLayer.getUsersFromDatabaseByUserName(userEmail);
        if (users == null) return null;
        return UserDetailsImpl.build(users);
    }
}
