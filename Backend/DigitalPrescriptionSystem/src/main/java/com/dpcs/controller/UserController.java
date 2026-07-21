package com.dpcs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;
import com.dpcs.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Validated @RequestBody UserRequest request){

        User user=service.registerUser(request);

        return new ResponseEntity<>(user,HttpStatus.CREATED);

    }

}