package com.dpcs.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.dpcs.dto.MedicineRequest;
import com.dpcs.entity.Medicine;
import com.dpcs.service.MedicineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @PostMapping
    public Medicine save(@Valid @RequestBody MedicineRequest request) {
        return service.save(request);
    }

    @GetMapping("/all")
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
    @GetMapping("/search/name")
    public List<Medicine> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }
    @GetMapping("/search/generic")
    public List<Medicine> searchByGenericName(@RequestParam String genericName) {
        return service.searchByGenericName(genericName);
    }
    
    @GetMapping("/search/manufacturer")
    public List<Medicine> searchByManufacturer(@RequestParam String manufacturer) {
        return service.searchByManufacturer(manufacturer);
    }
    
    @GetMapping("/search/strength")
    public List<Medicine> searchByStrength(@RequestParam String strength) {
        return service.searchByStrength(strength);
    }
    
    @GetMapping("/search/dosage")
    public List<Medicine> searchByDosage(@RequestParam String dosageForm) {
        return service.searchByDosageForm(dosageForm);
    }
    
    @GetMapping("/search/price")
    public List<Medicine> searchByExactPrice(@RequestParam Double price) {
        return service.searchByExactPrice(price);
    }
    @GetMapping("/search/price/max")
    public List<Medicine> searchByMaxPrice(@RequestParam Double price) {
        return service.searchByMaxPrice(price);
    }
    
    @GetMapping("/search/price/min")
    public List<Medicine> searchByMinPrice(@RequestParam Double price) {
        return service.searchByMinPrice(price);
    }
    
    @GetMapping("/search/price/range")
    public List<Medicine> searchByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return service.searchByPriceRange(minPrice, maxPrice);
    }
    
    @GetMapping("/search/stock")
    public List<Medicine> searchByExactStock(@RequestParam Integer stock) {
        return service.searchByExactStock(stock);
    }
    
    @GetMapping("/search/stock/min")
    public List<Medicine> searchByMinStock(@RequestParam Integer stock) {
        return service.searchByMinStock(stock);
    }
    
    @GetMapping("/search/stock/max")
    public List<Medicine> searchByMaxStock(@RequestParam Integer stock) {
        return service.searchByMaxStock(stock);
    }
    
    @GetMapping("/search/active")
    public List<Medicine> searchActive(@RequestParam Boolean active) {
        return service.searchActive(active);
    }
    
    @GetMapping
    public Page<Medicine> getMedicines(Pageable pageable) {

        return service.getMedicines(pageable);

    }
    
    @PutMapping("/{id}")
    public Medicine update(
            @PathVariable String id,
            @Valid @RequestBody MedicineRequest request) {

        return service.update(id, request);
    }
}