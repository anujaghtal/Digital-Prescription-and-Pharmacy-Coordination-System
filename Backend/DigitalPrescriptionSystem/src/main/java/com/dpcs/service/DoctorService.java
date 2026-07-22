package com.dpcs.service;

import com.dpcs.dto.DoctorRequest;
import com.dpcs.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(DoctorRequest request);

    List<Doctor> getAllDoctors();

    Doctor getDoctor(String id);

    void deleteDoctor(String id);
    List<Doctor> searchBySpecialization(String specialization);

    Doctor searchByLicenseNumber(String licenseNumber);

    List<Doctor> searchByExperience(Integer years);

    List<Doctor> searchByExactFee(Double fee);

    List<Doctor> searchByMaxFee(Double fee);

    List<Doctor> searchByMinFee(Double fee);

    List<Doctor> searchByFeeRange(Double minFee, Double maxFee);
}