package com.dpcs.controller;

import java.util.List;

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

    @GetMapping
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

}