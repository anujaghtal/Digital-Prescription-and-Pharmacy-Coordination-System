package com.dpcs.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;
import com.dpcs.exception.EmailAlreadyExistsException;
import com.dpcs.repository.UserRepository;
import com.dpcs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRequest request) {
    	if (repository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        User user = new User();

        user.setName(request.getFullName());
        user.setEmail(request.getEmail());

        // IMPORTANT
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        return repository.save(user);
    }
}