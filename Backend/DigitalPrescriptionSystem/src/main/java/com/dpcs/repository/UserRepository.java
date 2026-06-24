package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpcs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods (we will use later)

    User findByEmail(String email);

}