package com.ausias.jwt_auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ausias.jwt_auth.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService oUserService;
}
