package com.dpcs.service;

import java.util.List;

import com.dpcs.dto.PrescriptionRequest;
import com.dpcs.entity.Prescription;

public interface PrescriptionService {

    Prescription create(PrescriptionRequest request);

    List<Prescription> getAll();

    Prescription get(String id);

    void delete(String id);

}