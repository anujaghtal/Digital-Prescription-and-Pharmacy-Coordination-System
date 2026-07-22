package com.dpcs.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.PatientRequest;
import com.dpcs.entity.Patient;
import com.dpcs.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service){
        this.service=service;
    }

    @PostMapping
    public Patient save(@RequestBody PatientRequest request){
        return service.save(request);
    }

    @GetMapping("/all")
    public List<Patient> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient get(@PathVariable String id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
    @GetMapping("/search/gender")
    public List<Patient> searchByGender(@RequestParam String gender) {

        return service.searchByGender(gender);

    }

    @GetMapping("/search/blood-group")
    public List<Patient> searchByBloodGroup(@RequestParam String bloodGroup) {

        return service.searchByBloodGroup(bloodGroup);

    }

    @GetMapping("/search/emergency-contact")
    public List<Patient> searchByEmergencyContact(
            @RequestParam String emergencyContact) {

        return service.searchByEmergencyContact(emergencyContact);

    }
    @GetMapping
    public Page<Patient> getPatients(Pageable pageable) {

        return service.getPatients(pageable);

    }
    

}