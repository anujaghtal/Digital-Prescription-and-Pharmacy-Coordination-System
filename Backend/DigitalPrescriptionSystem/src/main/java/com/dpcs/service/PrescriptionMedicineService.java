package com.dpcs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dpcs.dto.PrescriptionMedicineRequest;
import com.dpcs.entity.PrescriptionMedicine;

public interface PrescriptionMedicineService {

    PrescriptionMedicine save(PrescriptionMedicineRequest request);

    List<PrescriptionMedicine> getAll();

    PrescriptionMedicine getById(String id);

    PrescriptionMedicine update(
            String id,
            PrescriptionMedicineRequest request);

    void delete(String id);

    List<PrescriptionMedicine> searchByPrescription(String prescriptionId);

    List<PrescriptionMedicine> searchByMedicine(String medicineId);

    List<PrescriptionMedicine> searchByMedicineName(String name);

    List<PrescriptionMedicine> searchByFrequency(String frequency);

    List<PrescriptionMedicine> searchByDuration(Integer duration);

    Page<PrescriptionMedicine> getAll(Pageable pageable);

}