package com.dpcs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    @GetMapping("/search/phone")
    public ResponseEntity<User> searchByPhone(@RequestParam String phone) {

        return service.searchByPhone(phone)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/search/email")
    public ResponseEntity<User> searchByEmail(@RequestParam String email) {

        return service.searchByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    
    @GetMapping("/search/name")
    public List<User> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/search/role")
    public List<User> searchByRole(@RequestParam String role) {
        return service.searchByRole(role);
    }
    @GetMapping
    public Page<User> getUsers(Pageable pageable) {

        return service.getUsers(pageable);

    }
    
    

}