package com.dpcs.service;

import com.dpcs.dto.DoctorRequest;
import com.dpcs.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(DoctorRequest request);

    List<Doctor> getAllDoctors();

    Doctor getDoctor(String id);

    void deleteDoctor(String id);

}