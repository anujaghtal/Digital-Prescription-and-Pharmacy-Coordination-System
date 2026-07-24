package com.dpcs.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
	 List<Appointment> findByDoctorId(String doctorId);

	    List<Appointment> findByPatientId(String patientId);

	    List<Appointment> findByStatusIgnoreCase(String status);

	    List<Appointment> findByAppointmentDateBetween(
	            LocalDateTime start,
	            LocalDateTime end);

	    List<Appointment> findByDoctorIdAndStatusIgnoreCase(
	            String doctorId,
	            String status);

	    List<Appointment> findByPatientIdAndStatusIgnoreCase(
	            String patientId,
	            String status);
}