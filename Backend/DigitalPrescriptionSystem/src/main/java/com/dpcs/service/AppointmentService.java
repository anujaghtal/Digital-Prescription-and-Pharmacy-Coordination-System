package com.dpcs.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dpcs.dto.AppointmentRequest;
import com.dpcs.entity.Appointment;

public interface AppointmentService {

    Appointment create(AppointmentRequest request);

    List<Appointment> getAll();

    Appointment getById(String id);

    void delete(String id);
    Appointment update(String id, AppointmentRequest request);

    List<Appointment> searchByDoctor(String doctorId);

    List<Appointment> searchByPatient(String patientId);

    List<Appointment> searchByStatus(String status);

    List<Appointment> searchByDate(
            LocalDateTime start,
            LocalDateTime end);

    List<Appointment> searchDoctorStatus(
            String doctorId,
            String status);

    List<Appointment> searchPatientStatus(
            String patientId,
            String status);

    Page<Appointment> getAppointments(Pageable pageable);
}