package com.dpcs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.DoctorRequest;
import com.dpcs.entity.Doctor;
import com.dpcs.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public Doctor save(@RequestBody DoctorRequest request) {
        return service.saveDoctor(request);
    }

    @GetMapping
    public List<Doctor> all() {
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor get(@PathVariable String id) {
        return service.getDoctor(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteDoctor(id);
    }

}