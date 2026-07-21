package com.dpcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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
        repository.deleteById(id);
    }
}