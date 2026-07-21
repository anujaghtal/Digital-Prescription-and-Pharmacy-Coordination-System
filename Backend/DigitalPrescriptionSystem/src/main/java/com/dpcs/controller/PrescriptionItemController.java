package com.dpcs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.PrescriptionItemRequest;
import com.dpcs.entity.PrescriptionItem;
import com.dpcs.service.PrescriptionItemService;

@RestController
@RequestMapping("/api/prescription-items")
public class PrescriptionItemController {

    private final PrescriptionItemService service;

    public PrescriptionItemController(
            PrescriptionItemService service) {

        this.service = service;
    }

    @PostMapping
    public PrescriptionItem save(
            @RequestBody PrescriptionItemRequest request) {

        return service.save(request);
    }

    @GetMapping
    public List<PrescriptionItem> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public PrescriptionItem getById(
            @PathVariable String id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id) {

        service.delete(id);

        return "Prescription Item Deleted Successfully";
    }

}