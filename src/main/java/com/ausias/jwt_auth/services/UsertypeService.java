package com.ausias.jwt_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ausias.jwt_auth.entities.UsertypeEntity;
import com.ausias.jwt_auth.repositories.UsertypeRepository;

@Service
public class UsertypeService {

    @Autowired
    UsertypeRepository oUsertypeRepository;
    
    public UsertypeEntity get(Long id) {
        return oUsertypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developer with id: " + id + " not found"));
    }
    
}
