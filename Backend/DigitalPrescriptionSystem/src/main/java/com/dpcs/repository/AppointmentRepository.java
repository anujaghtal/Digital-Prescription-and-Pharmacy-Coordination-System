package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

}