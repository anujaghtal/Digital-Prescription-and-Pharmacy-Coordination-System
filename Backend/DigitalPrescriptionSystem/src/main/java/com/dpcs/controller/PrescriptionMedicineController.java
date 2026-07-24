package com.dpcs.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.PrescriptionMedicineRequest;
import com.dpcs.entity.PrescriptionMedicine;
import com.dpcs.service.PrescriptionMedicineService;

@RestController
@RequestMapping("/api/prescription-medicines")
public class PrescriptionMedicineController {

    private final PrescriptionMedicineService service;

    public PrescriptionMedicineController(
            PrescriptionMedicineService service) {

        this.service = service;
    }

    // Create
    @PostMapping
    public PrescriptionMedicine save(
            @RequestBody PrescriptionMedicineRequest request) {

        return service.save(request);
    }

    // Pagination
    @GetMapping
    public Page<PrescriptionMedicine> getAll(Pageable pageable) {

        return service.getAll(pageable);
    }

    // Get All
    @GetMapping("/all")
    public List<PrescriptionMedicine> getAllList() {

        return service.getAll();
    }

    // Get By Id
    @GetMapping("/{id}")
    public PrescriptionMedicine getById(
            @PathVariable String id) {

        return service.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PrescriptionMedicine update(
            @PathVariable String id,
            @RequestBody PrescriptionMedicineRequest request) {

        return service.update(id, request);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id) {

        service.delete(id);

        return "Prescription Medicine Deleted Successfully";
    }

    // Search by Prescription
    @GetMapping("/search/prescription")
    public List<PrescriptionMedicine> searchPrescription(
            @RequestParam String prescriptionId) {

        return service.searchByPrescription(prescriptionId);
    }

    // Search by Medicine
    @GetMapping("/search/medicine")
    public List<PrescriptionMedicine> searchMedicine(
            @RequestParam String medicineId) {

        return service.searchByMedicine(medicineId);
    }

    // Search by Medicine Name
    @GetMapping("/search/name")
    public List<PrescriptionMedicine> searchMedicineName(
            @RequestParam String name) {

        return service.searchByMedicineName(name);
    }

    // Search by Frequency
    @GetMapping("/search/frequency")
    public List<PrescriptionMedicine> searchFrequency(
            @RequestParam String frequency) {

        return service.searchByFrequency(frequency);
    }

    // Search by Duration
    @GetMapping("/search/duration")
    public List<PrescriptionMedicine> searchDuration(
            @RequestParam Integer duration) {

        return service.searchByDuration(duration);
    }

}