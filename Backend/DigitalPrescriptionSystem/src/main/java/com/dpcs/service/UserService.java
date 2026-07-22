package com.dpcs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;

public interface UserService {
	
	Page<User> getUsers(Pageable pageable);
	
    User registerUser(UserRequest request);
    Optional<User> searchByPhone(String phone);

    Optional<User> searchByEmail(String email);
    List<User> searchByName(String name);

    List<User> searchByRole(String role);
    void delete(String id);
}