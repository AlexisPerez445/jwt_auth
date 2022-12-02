package com.ausias.jwt_auth.security;

import lombok.Data;

@Data
public class AuthCredentials {
    String username;
    String password;
}
