package com.ausias.jwt_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ausias.jwt_auth.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository oUserRepository;
}
