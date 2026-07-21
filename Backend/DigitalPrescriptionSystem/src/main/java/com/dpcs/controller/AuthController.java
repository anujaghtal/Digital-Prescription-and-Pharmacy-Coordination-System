package com.dpcs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.LoginRequest;
import com.dpcs.dto.LoginResponse;
import com.dpcs.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service=service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request){

        return ResponseEntity.ok(service.login(request));

    }

}