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

}