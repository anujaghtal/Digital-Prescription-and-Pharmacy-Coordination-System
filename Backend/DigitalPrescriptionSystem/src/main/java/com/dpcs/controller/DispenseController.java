package com.dpcs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.DispenseRequest;
import com.dpcs.entity.Dispense;
import com.dpcs.service.DispenseService;

@RestController
@RequestMapping("/api/dispenses")
public class DispenseController {

    private final DispenseService service;

    public DispenseController(DispenseService service) {

        this.service = service;

    }

    @PostMapping
    public Dispense dispense(
            @RequestBody DispenseRequest request){

        return service.dispense(request);

    }

    @GetMapping
    public List<Dispense> getAll(){

        return service.getAll();

    }

    @GetMapping("/{id}")
    public Dispense getById(
            @PathVariable String id){

        return service.getById(id);

    }

}