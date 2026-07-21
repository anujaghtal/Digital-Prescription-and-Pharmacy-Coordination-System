package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.Dispense;

public interface DispenseRepository
        extends JpaRepository<Dispense,String>{

}