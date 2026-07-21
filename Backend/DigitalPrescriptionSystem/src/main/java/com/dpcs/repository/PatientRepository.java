package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,String>{

}