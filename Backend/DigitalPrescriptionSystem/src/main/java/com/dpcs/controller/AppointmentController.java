package com.dpcs.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.AppointmentRequest;
import com.dpcs.entity.Appointment;
import com.dpcs.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public Appointment create(@RequestBody AppointmentRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable String id) {
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public Appointment update(
            @PathVariable String id,
            @RequestBody AppointmentRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Appointment Deleted Successfully";
    }
    // Search by Doctor
    @GetMapping("/search/doctor")
    public List<Appointment> searchByDoctor(
            @RequestParam String doctorId) {

        return service.searchByDoctor(doctorId);
    }

    // Search by Patient
    @GetMapping("/search/patient")
    public List<Appointment> searchByPatient(
            @RequestParam String patientId) {

        return service.searchByPatient(patientId);
    }

    // Search by Status
    @GetMapping("/search/status")
    public List<Appointment> searchByStatus(
            @RequestParam String status) {

        return service.searchByStatus(status);
    }
    // Search by Date Range
    @GetMapping("/search/date")
    public List<Appointment> searchByDate(

            @RequestParam LocalDateTime start,

            @RequestParam LocalDateTime end) {

        return service.searchByDate(start, end);
    }

    // Search Doctor + Status
    @GetMapping("/search/doctor/status")
    public List<Appointment> searchDoctorStatus(

            @RequestParam String doctorId,

            @RequestParam String status) {

        return service.searchDoctorStatus(
                doctorId,
                status);
    }
    // Search Patient + Status
    @GetMapping("/search/patient/status")
    public List<Appointment> searchPatientStatus(

            @RequestParam String patientId,

            @RequestParam String status) {

        return service.searchPatientStatus(
                patientId,
                status);
    }

    // Pagination
    @GetMapping("/page")
    public Page<Appointment> getAppointments(
            Pageable pageable) {

        return service.getAppointments(pageable);
    }
    
    
}