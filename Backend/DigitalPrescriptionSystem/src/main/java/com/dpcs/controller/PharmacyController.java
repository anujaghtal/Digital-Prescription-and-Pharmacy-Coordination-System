package com.dpcs.controller;

import java.util.List;

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
    public List<Pharmacy> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Pharmacy get(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Pharmacy Deleted Successfully";
    }

}