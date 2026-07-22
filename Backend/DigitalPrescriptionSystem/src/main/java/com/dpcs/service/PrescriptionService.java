package com.dpcs.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dpcs.dto.PrescriptionRequest;
import com.dpcs.entity.Prescription;

public interface PrescriptionService {

    Prescription create(PrescriptionRequest request);

    List<Prescription> getAll();

    Prescription get(String id);

    void delete(String id);
    List<Prescription> searchByDoctor(String doctorId);

    List<Prescription> searchByPatient(String patientId);

    List<Prescription> searchByStatus(String status);

    List<Prescription> searchByDateRange(
            LocalDateTime start,
            LocalDateTime end);

    List<Prescription> searchDoctorStatus(
            String doctorId,
            String status);

    List<Prescription> searchPatientStatus(
            String patientId,
            String status);
    
    Page<Prescription> getPrescriptions(Pageable pageable);

}