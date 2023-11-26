package com.jesus.courses.springboot.jwtauthenticationserver.app.services;

import com.jesus.courses.springboot.jwtauthenticationserver.app.models.User;
import com.jesus.courses.springboot.jwtauthenticationserver.app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
            }
        };
    }

    public User save(User newuser) {
        if (newuser.getId() == null) {
            newuser.setCreatedAt(LocalDateTime.now());
        }
        newuser.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(newuser);
    }

    public Long count() {
        return userRepository.count();
    }
}
