package com.dpcs.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Prescription;

public interface PrescriptionRepository
        extends JpaRepository<Prescription,String>{
	 List<Prescription> findByDoctor_Id(String doctorId);

	    List<Prescription> findByPatient_Id(String patientId);

	    List<Prescription> findByStatusIgnoreCase(String status);

	    List<Prescription> findByCreatedAtBetween(
	            LocalDateTime start,
	            LocalDateTime end);

	    List<Prescription> findByDoctor_IdAndStatusIgnoreCase(
	            String doctorId,
	            String status);

	    List<Prescription> findByPatient_IdAndStatusIgnoreCase(
	            String patientId,
	            String status);

	    List<Prescription> findByActive(Boolean active);
}