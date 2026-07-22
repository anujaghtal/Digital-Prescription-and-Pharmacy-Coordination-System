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
    @PutMapping("/{id}")
    public Dispense update(
            @PathVariable String id,
            @RequestBody DispenseRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        service.delete(id);

        return "Dispense Deleted Successfully";
    }

}