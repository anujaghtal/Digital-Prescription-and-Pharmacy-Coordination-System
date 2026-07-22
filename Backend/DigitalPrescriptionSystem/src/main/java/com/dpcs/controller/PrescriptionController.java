package com.dpcs.controller;

import com.dpcs.dto.PrescriptionRequest;
import com.dpcs.entity.Prescription;
import com.dpcs.service.PrescriptionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public Prescription createPrescription(
            @RequestBody PrescriptionRequest request) {

        return prescriptionService.create(request);
    }

    @GetMapping("/all")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAll();
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(
            @PathVariable String id) {

        return prescriptionService.get(id);
    }

    @DeleteMapping("/{id}")
    public String deletePrescription(
            @PathVariable String id) {

        prescriptionService.delete(id);
        return "Prescription Deleted Successfully";
    }
    @GetMapping("/search/doctor")
    public List<Prescription> searchDoctor(
            @RequestParam String doctorId) {

        return prescriptionService.searchByDoctor(doctorId);

    }
    
    @GetMapping("/search/patient")
    public List<Prescription> searchPatient(
            @RequestParam String patientId) {

        return prescriptionService.searchByPatient(patientId);

    }
    
    @GetMapping("/search/status")
    public List<Prescription> searchStatus(
            @RequestParam String status) {

        return prescriptionService.searchByStatus(status);

    }
    
    @GetMapping("/search/date-range")
    public List<Prescription> searchDateRange(

            @RequestParam LocalDateTime start,

            @RequestParam LocalDateTime end) {

        return prescriptionService.searchByDateRange(start, end);

    }
    
    @GetMapping("/search/doctor/status")
    public List<Prescription> searchDoctorStatus(

            @RequestParam String doctorId,

            @RequestParam String status) {

        return prescriptionService.searchDoctorStatus(
                doctorId,
                status);

    }
    
    @GetMapping("/search/patient/status")
    public List<Prescription> searchPatientStatus(

            @RequestParam String patientId,

            @RequestParam String status) {

        return prescriptionService.searchPatientStatus(
                patientId,
                status);

    }
    @GetMapping
    public Page<Prescription> getPrescriptions(Pageable pageable) {

        return prescriptionService.getPrescriptions(pageable);

    }

}