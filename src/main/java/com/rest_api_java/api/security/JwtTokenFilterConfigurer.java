package com.rest_api_java.api.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    private JwtTokenProvider jwtTokenProvider;

    //----------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------

    public JwtTokenFilterConfigurer(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    @Override
    public void configure(HttpSecurity builder) throws Exception {

        JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
        builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
