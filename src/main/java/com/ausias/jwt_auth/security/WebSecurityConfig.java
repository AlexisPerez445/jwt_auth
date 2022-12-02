package com.ausias.jwt_auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ausias.jwt_auth.services.UserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserService oUserService;
    private final JWTAuthorizationFilter oJwtAuthorizationFilter;


    @Bean
    SecurityFilterChain oFilterChain(HttpSecurity oHttpSecurity, AuthenticationManager oAuthenticationManager) throws Exception{

        JWTAuthenticationFilter oAuthenticationFilter = new JWTAuthenticationFilter();
        oAuthenticationFilter.setAuthenticationManager(oAuthenticationManager);
        oAuthenticationFilter.setFilterProcessesUrl("/login");

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
                .addFilter(oAuthenticationFilter)
                .addFilterBefore(oJwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authManager( HttpSecurity oHttpSecurity ) throws Exception{
        return oHttpSecurity
        .getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(oUserService)
        .passwordEncoder(passwordEncoder())
        .and()
        .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
