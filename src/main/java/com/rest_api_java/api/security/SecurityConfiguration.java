package com.rest_api_java.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    private JwtTokenProvider jwtTokenProvider;

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); //disable cross ref

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //only one session

        http.authorizeRequests()//
                .antMatchers("/users/signin").permitAll()//
                .antMatchers("/users/signup").permitAll()//
                .antMatchers("/users/**/**").authenticated()
                .antMatchers("/users/delete/**").authenticated()
                .antMatchers("/users/new").permitAll()
                .anyRequest().authenticated();

        // exptions
        http.exceptionHandling().accessDeniedPage("/login");

        // Apply JWT
        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }

    //----------------------------------------------------------------------

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
