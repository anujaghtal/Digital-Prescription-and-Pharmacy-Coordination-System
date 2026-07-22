package com.dpcs.service;

import java.util.List;

import com.dpcs.dto.DispenseRequest;
import com.dpcs.entity.Dispense;

public interface DispenseService {

    Dispense dispense(DispenseRequest request);

    List<Dispense> getAll();

    Dispense getById(String id);
    Dispense update(String id, DispenseRequest request);

    void delete(String id);

}