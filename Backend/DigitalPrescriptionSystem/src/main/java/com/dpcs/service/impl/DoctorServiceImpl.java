package com.dpcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dpcs.dto.DoctorRequest;
import com.dpcs.entity.Doctor;
import com.dpcs.repository.DoctorRepository;
import com.dpcs.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Doctor saveDoctor(DoctorRequest request) {

        Doctor doctor = new Doctor();

        doctor.setUserId(request.getUserId());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setLicenseNumber(request.getLicenseNumber());
        doctor.setYearsOfExperience(request.getYearsOfExperience());
        doctor.setConsultationFee(request.getConsultationFee());

        return repository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    @Override
    public Doctor getDoctor(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteDoctor(String id) {
        repository.deleteById(id);
    }

}