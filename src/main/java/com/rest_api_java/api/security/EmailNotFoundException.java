package com.rest_api_java.api.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmailNotFoundException extends UsernameNotFoundException {

    public EmailNotFoundException(String msg) {
        super(msg);
    }
}
