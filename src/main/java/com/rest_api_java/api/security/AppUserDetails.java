package com.rest_api_java.api.security;

import com.rest_api_java.api.model.User;
import com.rest_api_java.api.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetails implements UserDetailsService {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    private final UserRepository userRepository;

    public AppUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new EmailNotFoundException("User with email '" + username + "' could not be found");
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.getPassword())//
                .authorities(user.getRole())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }
}
