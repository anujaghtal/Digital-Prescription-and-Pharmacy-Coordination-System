package com.dpcs.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;
import com.dpcs.exception.EmailAlreadyExistsException;
import com.dpcs.repository.UserRepository;
import com.dpcs.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder encoder){
        this.repository=repository;
        this.encoder=encoder;
    }

    @Override
    public User registerUser(UserRequest request){

        if(repository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        User user=new User();

//        user.setFullName(request.getFullName());
//        user.setEmail(request.getEmail());
//        user.setPasswordHash(encoder.encode(request.getPassword()));
//        user.setRole(request.getRole());
//        user.setPhone(request.getPhone());

        return repository.save(user);

    }

}