package com.michael.aplicationTodoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.aplicationTodoList.models.UserModel;
import com.michael.aplicationTodoList.repository.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository UserRepository;
 @GetMapping("/listusers") 

    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = this.UserRepository.findAll();

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(users); 
    }




@PostMapping("/createUser")
    public ResponseEntity create (@RequestBody UserModel userModel) {
         var user=this.UserRepository.findByUsername(userModel.getUsername());

        if(user != null) {  

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");   
       
        }
         
            var passwordHashred = BCrypt.withDefaults()
            .hashToString(12,userModel.getPassword().toCharArray());

            userModel.setPassword(passwordHashred);

            var userCreated = this.UserRepository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created.");
      

    }
 
}
