package com.dpcs.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dpcs.dto.LoginRequest;
import com.dpcs.dto.LoginResponse;
import com.dpcs.entity.User;
import com.dpcs.repository.UserRepository;
import com.dpcs.security.JwtService;
import com.dpcs.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository repository,
                           PasswordEncoder encoder,
                           JwtService jwtService) {

        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if(!encoder.matches(request.getPassword(),
                user.getPassword())){

            throw new RuntimeException("Invalid Password");
        }

        String token=jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                token,
                user.getRole(),
                "Login Successful"
        );

    }

}