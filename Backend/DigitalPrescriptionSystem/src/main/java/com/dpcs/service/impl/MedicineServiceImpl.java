package com.dpcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dpcs.dto.MedicineRequest;
import com.dpcs.entity.Medicine;
import com.dpcs.repository.MedicineRepository;
import com.dpcs.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository repository;

    public MedicineServiceImpl(MedicineRepository repository) {
        this.repository = repository;
    }

    @Override
    public Medicine save(MedicineRequest request) {

        if(repository.existsByName(request.getName())) {
            throw new RuntimeException("Medicine already exists");
        }

        Medicine medicine = new Medicine();

        medicine.setName(request.getName());
        medicine.setGenericName(request.getGenericName());
        medicine.setManufacturer(request.getManufacturer());
        medicine.setStrength(request.getStrength());
        medicine.setDosageForm(request.getDosageForm());
        medicine.setPrice(request.getPrice());
        medicine.setStockQuantity(request.getStockQuantity());

        return repository.save(medicine);
    }

    @Override
    public List<Medicine> getAll() {
        return repository.findAll();
    }

    @Override
    public Medicine getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
    @Override
    public List<Medicine> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Medicine> searchByGenericName(String genericName) {
        return repository.findByGenericNameContainingIgnoreCase(genericName);
    }

    @Override
    public List<Medicine> searchByManufacturer(String manufacturer) {
        return repository.findByManufacturerContainingIgnoreCase(manufacturer);
    }

    @Override
    public List<Medicine> searchByStrength(String strength) {
        return repository.findByStrengthIgnoreCase(strength);
    }

    @Override
    public List<Medicine> searchByDosageForm(String dosageForm) {
        return repository.findByDosageFormIgnoreCase(dosageForm);
    }

    @Override
    public List<Medicine> searchByExactPrice(Double price) {
        return repository.findByPrice(price);
    }

    @Override
    public List<Medicine> searchByMaxPrice(Double price) {
        return repository.findByPriceLessThanEqual(price);
    }

    @Override
    public List<Medicine> searchByMinPrice(Double price) {
        return repository.findByPriceGreaterThanEqual(price);
    }

    @Override
    public List<Medicine> searchByPriceRange(Double minPrice, Double maxPrice) {
        return repository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Medicine> searchByExactStock(Integer stock) {
        return repository.findByStockQuantity(stock);
    }

    @Override
    public List<Medicine> searchByMinStock(Integer stock) {
        return repository.findByStockQuantityGreaterThanEqual(stock);
    }

    @Override
    public List<Medicine> searchByMaxStock(Integer stock) {
        return repository.findByStockQuantityLessThanEqual(stock);
    }

    @Override
    public List<Medicine> searchActive(Boolean active) {
        return repository.findByActive(active);
    }

}