package com.dpcs.service.impl;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dpcs.exception.ResourceNotFoundException;
import com.dpcs.dto.AppointmentRequest;
import com.dpcs.entity.Appointment;
import com.dpcs.repository.AppointmentRepository;
import com.dpcs.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Appointment create(AppointmentRequest request) {

        Appointment appointment = new Appointment();

        appointment.setDoctorId(request.getDoctorId());
        appointment.setPatientId(request.getPatientId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setStatus(request.getStatus());
        appointment.setNotes(request.getNotes());

        return repository.save(appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return repository.findAll();
    }

    @Override
    public Appointment getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {

        Appointment appointment = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Appointment not found"));

        repository.delete(appointment);

    }
    @Override
    public Appointment update(
            String id,
            AppointmentRequest request) {

        Appointment appointment = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Appointment not found"));

        appointment.setDoctorId(request.getDoctorId());
        appointment.setPatientId(request.getPatientId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setStatus(request.getStatus());
        appointment.setNotes(request.getNotes());

        return repository.save(appointment);
    }
    @Override
    public List<Appointment> searchByDoctor(String doctorId) {

        return repository.findByDoctorId(doctorId);

    }
    @Override
    public List<Appointment> searchByPatient(String patientId) {

        return repository.findByPatientId(patientId);

    }
    
    @Override
    public List<Appointment> searchByStatus(String status) {

        return repository.findByStatusIgnoreCase(status);

    }
    
    @Override
    public List<Appointment> searchByDate(
            LocalDateTime start,
            LocalDateTime end) {

        return repository.findByAppointmentDateBetween(start, end);

    }
    
    @Override
    public List<Appointment> searchDoctorStatus(
            String doctorId,
            String status) {

        return repository.findByDoctorIdAndStatusIgnoreCase(
                doctorId,
                status);

    }
    
    @Override
    public List<Appointment> searchPatientStatus(
            String patientId,
            String status) {

        return repository.findByPatientIdAndStatusIgnoreCase(
                patientId,
                status);

    }
    @Override
    public Page<Appointment> getAppointments(Pageable pageable) {

        return repository.findAll(pageable);

    }
}