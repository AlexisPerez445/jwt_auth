package com.ausias.jwt_auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ausias.jwt_auth.entities.UserEntity;
import com.ausias.jwt_auth.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService oUserService;


    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<UserEntity>(oUserService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Long> create(@RequestBody UserEntity onewuUserEntity) {
        return new ResponseEntity<Long>(oUserService.create(onewuUserEntity), HttpStatus.OK);
    }
}
