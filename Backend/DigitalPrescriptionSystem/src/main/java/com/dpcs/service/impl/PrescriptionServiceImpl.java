package com.dpcs.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dpcs.dto.PrescriptionRequest;
import com.dpcs.entity.Appointment;
import com.dpcs.entity.Doctor;
import com.dpcs.entity.Patient;
import com.dpcs.entity.Prescription;
import com.dpcs.repository.AppointmentRepository;
import com.dpcs.repository.DoctorRepository;
import com.dpcs.repository.PatientRepository;
import com.dpcs.repository.PrescriptionRepository;
import com.dpcs.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public PrescriptionServiceImpl(
            PrescriptionRepository prescriptionRepository,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository,
            AppointmentRepository appointmentRepository) {

        this.prescriptionRepository = prescriptionRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Prescription create(PrescriptionRequest request) {

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Prescription prescription = new Prescription();

        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setAppointment(appointment);
        prescription.setDiagnosis(request.getDiagnosis());
        prescription.setNotes(request.getNotes());
        prescription.setStatus("ACTIVE");

        return prescriptionRepository.save(prescription);
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription get(String id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

    @Override
    public void delete(String id) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        prescriptionRepository.delete(prescription);
    }
    
    @Override
    public List<Prescription> searchByDoctor(String doctorId) {

        return prescriptionRepository.findByDoctor_Id(doctorId);

    }

    @Override
    public List<Prescription> searchByPatient(String patientId) {

        return prescriptionRepository.findByPatient_Id(patientId);

    }

    @Override
    public List<Prescription> searchByStatus(String status) {

        return prescriptionRepository.findByStatusIgnoreCase(status);

    }

    @Override
    public List<Prescription> searchByDateRange(
            LocalDateTime start,
            LocalDateTime end) {

        return prescriptionRepository.findByCreatedAtBetween(start, end);

    }

    @Override
    public List<Prescription> searchDoctorStatus(
            String doctorId,
            String status) {

        return prescriptionRepository.findByDoctor_IdAndStatusIgnoreCase(
                doctorId,
                status);

    }

    @Override
    public List<Prescription> searchPatientStatus(
            String patientId,
            String status) {

        return prescriptionRepository.findByPatient_IdAndStatusIgnoreCase(
                patientId,
                status);

    }

}