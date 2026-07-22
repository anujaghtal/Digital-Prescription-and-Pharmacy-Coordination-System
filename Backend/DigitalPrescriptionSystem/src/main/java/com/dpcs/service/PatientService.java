package com.dpcs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dpcs.dto.PatientRequest;
import com.dpcs.entity.Patient;

public interface PatientService {

    Patient save(PatientRequest request);

    List<Patient> getAll();

    Patient getById(String id);

    void delete(String id);
    List<Patient> searchByGender(String gender);

    List<Patient> searchByBloodGroup(String bloodGroup);

    List<Patient> searchByEmergencyContact(String emergencyContact);
    
    Page<Patient> getPatients(Pageable pageable);
    
    Patient update(String id, PatientRequest request);

}