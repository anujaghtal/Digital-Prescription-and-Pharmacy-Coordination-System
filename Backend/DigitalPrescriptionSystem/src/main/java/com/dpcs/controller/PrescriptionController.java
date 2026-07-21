package com.dpcs.controller;

import com.dpcs.dto.PrescriptionRequest;
import com.dpcs.entity.Prescription;
import com.dpcs.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public Prescription createPrescription(
            @RequestBody PrescriptionRequest request) {

        return prescriptionService.create(request);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAll();
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(
            @PathVariable String id) {

        return prescriptionService.get(id);
    }

    @DeleteMapping("/{id}")
    public String deletePrescription(
            @PathVariable String id) {

        prescriptionService.delete(id);
        return "Prescription Deleted Successfully";
    }

}