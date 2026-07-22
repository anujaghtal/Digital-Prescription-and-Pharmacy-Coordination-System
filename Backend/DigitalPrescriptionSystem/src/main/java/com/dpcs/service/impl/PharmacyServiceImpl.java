package com.dpcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dpcs.dto.PharmacyRequest;
import com.dpcs.entity.Pharmacy;
import com.dpcs.exception.DuplicateResourceException;
import com.dpcs.exception.ResourceNotFoundException;
import com.dpcs.repository.PharmacyRepository;
import com.dpcs.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository repository;

    public PharmacyServiceImpl(PharmacyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pharmacy save(PharmacyRequest request) {

        if(repository.existsByLicenseNumber(request.getLicenseNumber())){
            throw new DuplicateResourceException("License Number Already Exists");
        }

        Pharmacy pharmacy = new Pharmacy();

        pharmacy.setName(request.getName());
        pharmacy.setLicenseNumber(request.getLicenseNumber());
        pharmacy.setOwnerName(request.getOwnerName());
        pharmacy.setEmail(request.getEmail());
        pharmacy.setPhone(request.getPhone());
        pharmacy.setAddress(request.getAddress());

        return repository.save(pharmacy);
    }

    @Override
    public List<Pharmacy> getAll() {
        return repository.findAll();
    }

    @Override
    public Pharmacy getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found"));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}