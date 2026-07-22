package com.dpcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,String>{
	  List<Patient> findByGenderIgnoreCase(String gender);

	    List<Patient> findByBloodGroupIgnoreCase(String bloodGroup);

	    List<Patient> findByEmergencyContact(String emergencyContact);

	    List<Patient> findByUserId(String userId);
}