package com.ausias.jwt_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ausias.jwt_auth.entities.UserEntity;
import com.ausias.jwt_auth.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    UserRepository oUserRepository;

    

    public UserEntity getUser(Long id) {
        return oUserRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developer with id: " + id + " not found"));
    }

    public Long create(UserEntity oNewUserEntity) {
        oNewUserEntity.setId(0L);
         String password =  passwordEncoder().encode(oNewUserEntity.getPassword());
         oNewUserEntity.setPassword(password);
        return oUserRepository.save(oNewUserEntity).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return oUserRepository.findOneByUsername(username);
    }


    static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
}
