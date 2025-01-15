package com.olx.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.olx.user.repository.UserRepository;
import com.olx.user.entity.UserEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Load user from USERS table using the Repository API
        List<UserEntity> list = repository.findByUserName(username);
        
        if (list == null || list.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // If no exception, username exists, now retrieve user data
        UserEntity entity = list.get(0);
        
        // Prepare the authorities (roles) for the user
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String roles = entity.getRoles();
        String[] roleArray = roles.split(",");
        for (String role : roleArray) {
            authorities.add(new SimpleGrantedAuthority(role.trim()));
        }

        // Return the UserDetails with encoded password (don't encode it again here)
        return new User(entity.getUserName(), entity.getPassword(), authorities);
    }
}
