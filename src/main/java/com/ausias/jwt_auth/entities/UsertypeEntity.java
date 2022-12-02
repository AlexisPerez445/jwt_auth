package com.ausias.jwt_auth.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usertype")
public class UsertypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "usertype", fetch = FetchType.LAZY)
    private final List<UserEntity> users;

    public UsertypeEntity() {
        this.users = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUsers() {
        return users.size();
    }

    public UsertypeEntity(Long id, String name) {
        this.id = id;
        this.name = name;
        this.users = new ArrayList<>();
    }
}
