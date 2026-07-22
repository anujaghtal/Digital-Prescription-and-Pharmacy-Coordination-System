package com.dpcs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    List<User> findByNameContainingIgnoreCase(String name);

    Optional<User> findByPhone(String phone);

    List<User> findByRole(String role);

}