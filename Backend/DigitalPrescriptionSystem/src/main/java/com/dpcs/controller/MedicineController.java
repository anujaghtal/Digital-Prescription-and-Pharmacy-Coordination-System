package com.dpcs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.MedicineRequest;
import com.dpcs.entity.Medicine;
import com.dpcs.service.MedicineService;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @PostMapping
    public Medicine save(@RequestBody MedicineRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<Medicine> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Medicine get(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        service.delete(id);

        return "Medicine Deleted Successfully";
    }

}