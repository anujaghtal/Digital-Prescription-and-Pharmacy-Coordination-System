package com.dpcs.service;

import java.util.List;

import com.dpcs.dto.MedicineRequest;
import com.dpcs.entity.Medicine;

public interface MedicineService {

    Medicine save(MedicineRequest request);

    List<Medicine> getAll();

    Medicine getById(String id);

    void delete(String id);

}