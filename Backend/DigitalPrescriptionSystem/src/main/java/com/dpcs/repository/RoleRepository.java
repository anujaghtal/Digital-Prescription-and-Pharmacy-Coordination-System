package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}