package com.ausias.jwt_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ausias.jwt_auth.entities.UsertypeEntity;

public interface UsertypeRepository extends JpaRepository<UsertypeEntity, Long>{
    
}
