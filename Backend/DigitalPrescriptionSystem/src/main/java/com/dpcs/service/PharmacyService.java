package com.dpcs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dpcs.dto.PharmacyRequest;
import com.dpcs.entity.Pharmacy;

public interface PharmacyService {

    Pharmacy save(PharmacyRequest request);

    List<Pharmacy> getAll();

    Pharmacy getById(String id);
    Pharmacy update(String id, PharmacyRequest request);
    void delete(String id);
    
    List<Pharmacy> searchByName(String name);

    Pharmacy searchByLicense(String licenseNumber);

    List<Pharmacy> searchByOwner(String ownerName);

    List<Pharmacy> searchByEmail(String email);

    List<Pharmacy> searchByPhone(String phone);

    List<Pharmacy> searchByAddress(String address);

    List<Pharmacy> searchByActive(Boolean active);

    Page<Pharmacy> getPharmacies(Pageable pageable);

}