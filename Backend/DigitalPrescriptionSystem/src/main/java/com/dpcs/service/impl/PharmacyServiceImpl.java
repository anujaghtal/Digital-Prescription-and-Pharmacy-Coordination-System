package com.dpcs.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        Pharmacy pharmacy = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pharmacy not found"));

        repository.delete(pharmacy);
    }
    @Override
    public Pharmacy update(String id, PharmacyRequest request) {

        Pharmacy pharmacy = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pharmacy not found"));

        pharmacy.setName(request.getName());
        pharmacy.setLicenseNumber(request.getLicenseNumber());
        pharmacy.setOwnerName(request.getOwnerName());
        pharmacy.setEmail(request.getEmail());
        pharmacy.setPhone(request.getPhone());
        pharmacy.setAddress(request.getAddress());
       // pharmacy.setActive(request.getActive());

        return repository.save(pharmacy);
    }
    @Override
    public List<Pharmacy> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Pharmacy searchByLicense(String licenseNumber) {
        return repository.findByLicenseNumber(licenseNumber);
    }

    @Override
    public List<Pharmacy> searchByOwner(String ownerName) {
        return repository.findByOwnerNameContainingIgnoreCase(ownerName);
    }

    @Override
    public List<Pharmacy> searchByEmail(String email) {
        return repository.findByEmailContainingIgnoreCase(email);
    }
    
    @Override
    public List<Pharmacy> searchByPhone(String phone) {
        return repository.findByPhoneContainingIgnoreCase(phone);
    }

    @Override
    public List<Pharmacy> searchByAddress(String address) {
        return repository.findByAddressContainingIgnoreCase(address);
    }

    @Override
    public List<Pharmacy> searchByActive(Boolean active) {
        return repository.findByActive(active);
    }

    @Override
    public Page<Pharmacy> getPharmacies(Pageable pageable) {
        return repository.findAll(pageable);
    }

}