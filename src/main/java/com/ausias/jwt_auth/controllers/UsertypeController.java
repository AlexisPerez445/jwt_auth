package com.ausias.jwt_auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ausias.jwt_auth.entities.UsertypeEntity;
import com.ausias.jwt_auth.services.UsertypeService;

@RestController
@RequestMapping("/usertype")
public class UsertypeController {


    @Autowired
    UsertypeService oUsertypeService;

    @GetMapping("/{id}")
    public ResponseEntity<UsertypeEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<UsertypeEntity>(oUsertypeService.get(id), HttpStatus.OK);
    }


}
