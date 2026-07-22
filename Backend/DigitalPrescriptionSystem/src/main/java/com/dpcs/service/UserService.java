package com.dpcs.service;

import java.util.List;
import java.util.Optional;

import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;

public interface UserService {

    User registerUser(UserRequest request);
    Optional<User> searchByPhone(String phone);

    Optional<User> searchByEmail(String email);
    List<User> searchByName(String name);

    List<User> searchByRole(String role);
}