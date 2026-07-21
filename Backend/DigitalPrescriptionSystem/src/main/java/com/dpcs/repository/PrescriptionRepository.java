package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Prescription;

public interface PrescriptionRepository
        extends JpaRepository<Prescription,String>{

}