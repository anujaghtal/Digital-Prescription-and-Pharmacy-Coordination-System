package com.dpcs.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;
import com.dpcs.exception.EmailAlreadyExistsException;
import com.dpcs.exception.ResourceNotFoundException;
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
    
    @Override
    public List<User> searchByName(String name) {

        return repository.findByNameContainingIgnoreCase(name);

    }

    @Override
    public Optional<User> searchByPhone(String phone) {

        return repository.findByPhone(phone);

    }
    @Override
    public Optional<User> searchByEmail(String email) {

        return repository.findByEmail(email);

    }

    @Override
    public List<User> searchByRole(String role) {

        return repository.findByRole(role);

    }
    @Override
    public Page<User> getUsers(Pageable pageable) {

        return repository.findAll(pageable);

    }
    @Override
    public void delete(String id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        repository.delete(user);
    }
    
}