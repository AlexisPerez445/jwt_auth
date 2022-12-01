package com.ausias.jwt_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ausias.jwt_auth.repositories.UsertypeRepository;

@Service
public class UsertypeService {

    @Autowired
    UsertypeRepository oUsertypeRepository;
    
}
