package com.michael.aplicationTodoList.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michael.aplicationTodoList.models.UserModel;


public interface UserRepository extends JpaRepository <UserModel, UUID>{
    UserModel findByUsername(String username);


}