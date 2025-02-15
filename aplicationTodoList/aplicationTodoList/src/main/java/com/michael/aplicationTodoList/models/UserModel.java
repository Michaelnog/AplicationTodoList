package com.michael.aplicationTodoList.models;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="tb_users")
public class UserModel {


    @Id
    @GeneratedValue(generator= "UUID")
    private UUID id;


    @Column(unique= true)
    private String username ;
    private String name;
    private Long phoneNumber;
    private String email;
    private String address;
    private String Ssn;
    private Long zipcode;
    private String password;

    @CreationTimestamp
    private java.time.LocalDateTime createdAt;
}
