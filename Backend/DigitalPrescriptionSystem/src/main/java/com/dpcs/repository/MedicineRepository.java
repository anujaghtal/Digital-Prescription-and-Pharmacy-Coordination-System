package com.dpcs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,String>{

    boolean existsByName(String name);

    Optional<Medicine> findByName(String name);

}