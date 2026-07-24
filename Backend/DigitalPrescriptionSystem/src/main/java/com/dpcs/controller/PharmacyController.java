package com.dpcs.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.PharmacyRequest;
import com.dpcs.entity.Pharmacy;
import com.dpcs.service.PharmacyService;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {

    private final PharmacyService service;

    public PharmacyController(PharmacyService service) {
        this.service = service;
    }

    @PostMapping
    public Pharmacy save(@RequestBody PharmacyRequest request) {
        return service.save(request);
    }

    @GetMapping
    public Page<Pharmacy> getPharmacies(Pageable pageable) {
        return service.getPharmacies(pageable);
    }

    @GetMapping("/all")
    public List<Pharmacy> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Pharmacy get(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Pharmacy update(
            @PathVariable String id,
            @RequestBody PharmacyRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Pharmacy Deleted Successfully";
    }
    
    @GetMapping("/search/name")
    public List<Pharmacy> searchByName(
            @RequestParam String name) {

        return service.searchByName(name);
    }

    @GetMapping("/search/license")
    public Pharmacy searchByLicense(
            @RequestParam String licenseNumber) {

        return service.searchByLicense(licenseNumber);
    }

    @GetMapping("/search/owner")
    public List<Pharmacy> searchByOwner(
            @RequestParam String ownerName) {

        return service.searchByOwner(ownerName);
    }
    
    @GetMapping("/search/email")
    public List<Pharmacy> searchByEmail(
            @RequestParam String email) {

        return service.searchByEmail(email);
    }

    @GetMapping("/search/phone")
    public List<Pharmacy> searchByPhone(
            @RequestParam String phone) {

        return service.searchByPhone(phone);
    }

    @GetMapping("/search/address")
    public List<Pharmacy> searchByAddress(
            @RequestParam String address) {
    	 return service.searchByAddress(address);
    }

    @GetMapping("/search/active")
    public List<Pharmacy> searchByActive(
            @RequestParam Boolean active) {

        return service.searchByActive(active);
    }

}