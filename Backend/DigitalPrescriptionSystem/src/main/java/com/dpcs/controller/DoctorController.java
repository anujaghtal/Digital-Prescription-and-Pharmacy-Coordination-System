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
    
    @GetMapping("/search/specialization")
    public List<Doctor> searchBySpecialization(
            @RequestParam String specialization) {

        return service.searchBySpecialization(specialization);

    }

    @GetMapping("/search/license")
    public Doctor searchByLicense(
            @RequestParam String licenseNumber) {

        return service.searchByLicenseNumber(licenseNumber);

    }

    @GetMapping("/search/experience")
    public List<Doctor> searchByExperience(
            @RequestParam Integer years) {

        return service.searchByExperience(years);

    }

    @GetMapping("/search/fee")
    public List<Doctor> searchByExactFee(
            @RequestParam Double fee) {

        return service.searchByExactFee(fee);

    }
    @GetMapping("/search/fee/max")
    public List<Doctor> searchByMaxFee(
            @RequestParam Double fee) {

        return service.searchByMaxFee(fee);

    }
    @GetMapping("/search/fee/min")
    public List<Doctor> searchByMinFee(
            @RequestParam Double fee) {

        return service.searchByMinFee(fee);

    }
    @GetMapping("/search/fee/range")
    public List<Doctor> searchByRange(

            @RequestParam Double minFee,

            @RequestParam Double maxFee) {

        return service.searchByFeeRange(minFee, maxFee);

    }

}