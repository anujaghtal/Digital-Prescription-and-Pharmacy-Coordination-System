package com.dpcs.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.PrescriptionMedicine;

public interface PrescriptionMedicineRepository
        extends JpaRepository<PrescriptionMedicine, String> {

    List<PrescriptionMedicine> findByPrescription_Id(String prescriptionId);

    List<PrescriptionMedicine> findByMedicine_Id(String medicineId);

    List<PrescriptionMedicine> findByMedicine_NameContainingIgnoreCase(String name);

    List<PrescriptionMedicine> findByFrequencyIgnoreCase(String frequency);

    List<PrescriptionMedicine> findByDurationDays(Integer durationDays);

    Page<PrescriptionMedicine> findAll(Pageable pageable);

}