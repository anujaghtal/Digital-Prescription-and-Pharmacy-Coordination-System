package com.dpcs.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    @Override
    public List<Doctor> searchBySpecialization(String specialization) {

        return repository.findBySpecializationContainingIgnoreCase(specialization);

    }

    @Override
    public Doctor searchByLicenseNumber(String licenseNumber) {

        return repository.findByLicenseNumber(licenseNumber);

    }

    @Override
    public List<Doctor> searchByExperience(Integer years) {

        return repository.findByYearsOfExperience(years);

    }
    
    @Override
    public List<Doctor> searchByExactFee(Double fee) {

        return repository.findByConsultationFee(fee);

    }

    @Override
    public List<Doctor> searchByMaxFee(Double fee) {

        return repository.findByConsultationFeeLessThanEqual(fee);

    }

    @Override
    public List<Doctor> searchByMinFee(Double fee) {

        return repository.findByConsultationFeeGreaterThanEqual(fee);

    }

    @Override
    public List<Doctor> searchByFeeRange(Double minFee, Double maxFee) {

        return repository.findByConsultationFeeBetween(minFee, maxFee);

    }
    
    @Override
    public Page<Doctor> getDoctors(Pageable pageable) {

        return repository.findAll(pageable);

    }
    
}