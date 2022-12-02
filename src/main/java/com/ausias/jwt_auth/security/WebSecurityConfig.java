package com.ausias.jwt_auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.ausias.jwt_auth.services.UserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserService oUserService;
    private final JWTAuthorizationFilter oJwtAuthorizationFilter;

    @Bean
    SecurityFilterChain oFilterChain(HttpSecurity oHttpSecurity, AuthenticationManager oAuthenticationManager) throws Exception{

        JWTAuthorizationFilter jwtAuthorizationFilter = new JWTAuthorizationFilter();
        jwtAuthorizationFilter.setAuthenticationManager(oAuthenticationManager);

        return oHttpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }
    
}
