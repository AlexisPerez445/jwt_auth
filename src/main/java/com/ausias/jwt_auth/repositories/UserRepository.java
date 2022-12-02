package com.ausias.jwt_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ausias.jwt_auth.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findOneByUsername(String username);
    
}
