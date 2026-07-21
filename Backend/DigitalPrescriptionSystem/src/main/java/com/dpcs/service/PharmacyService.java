package com.dpcs.service;

import java.util.List;

import com.dpcs.dto.PharmacyRequest;
import com.dpcs.entity.Pharmacy;

public interface PharmacyService {

    Pharmacy save(PharmacyRequest request);

    List<Pharmacy> getAll();

    Pharmacy getById(String id);

    void delete(String id);

}