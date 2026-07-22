package com.dpcs.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dpcs.dto.PatientRequest;
import com.dpcs.entity.Patient;
import com.dpcs.repository.PatientRepository;
import com.dpcs.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository){
        this.repository=repository;
    }

    @Override
    public Patient save(PatientRequest request){

        Patient patient=new Patient();

        patient.setUserId(request.getUserId());
        patient.setDob(request.getDob());
        patient.setGender(request.getGender());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setHeight(request.getHeight());
        patient.setWeight(request.getWeight());
        patient.setEmergencyContact(request.getEmergencyContact());

        return repository.save(patient);

    }

    @Override
    public List<Patient> getAll(){
        return repository.findAll();
    }

    @Override
    public Patient getById(String id){
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id){
        repository.deleteById(id);
    }
    @Override
    public List<Patient> searchByGender(String gender) {

        return repository.findByGenderIgnoreCase(gender);

    }

    @Override
    public List<Patient> searchByBloodGroup(String bloodGroup) {

        return repository.findByBloodGroupIgnoreCase(bloodGroup);

    }

    @Override
    public List<Patient> searchByEmergencyContact(String emergencyContact) {

        return repository.findByEmergencyContact(emergencyContact);

    }
    
    @Override
    public Page<Patient> getPatients(Pageable pageable) {

        return repository.findAll(pageable);

    }

}