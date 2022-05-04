package com.sportyshoes.controllers;

import com.sportyshoes.dto.UserRequestDTO;
import com.sportyshoes.entities.Product;
import com.sportyshoes.entities.User;
import com.sportyshoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<User>(userService.registerUser(userRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    public List<User> getUser(){
        return this.userService.getUser();
    }

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable(name = "userId") int userId) {
        try {
            return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/user")
    public User updateProduct(@RequestBody User user) {

        return userService.updateProduct(user);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> removeUserById(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<User>(userService.removeUserById(id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
