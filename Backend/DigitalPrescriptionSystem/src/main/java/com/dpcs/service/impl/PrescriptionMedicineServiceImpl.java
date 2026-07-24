package com.dpcs.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dpcs.dto.PrescriptionMedicineRequest;
import com.dpcs.entity.Medicine;
import com.dpcs.entity.Prescription;
import com.dpcs.entity.PrescriptionMedicine;
import com.dpcs.exception.ResourceNotFoundException;
import com.dpcs.repository.MedicineRepository;
import com.dpcs.repository.PrescriptionMedicineRepository;
import com.dpcs.repository.PrescriptionRepository;
import com.dpcs.service.PrescriptionMedicineService;

@Service
public class PrescriptionMedicineServiceImpl
        implements PrescriptionMedicineService {

    private final PrescriptionMedicineRepository repository;
    private final PrescriptionRepository prescriptionRepository;
    private final MedicineRepository medicineRepository;

    public PrescriptionMedicineServiceImpl(
            PrescriptionMedicineRepository repository,
            PrescriptionRepository prescriptionRepository,
            MedicineRepository medicineRepository) {

        this.repository = repository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public PrescriptionMedicine save(PrescriptionMedicineRequest request) {

        Prescription prescription = prescriptionRepository
                .findById(request.getPrescriptionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription not found"));

        Medicine medicine = medicineRepository
                .findById(request.getMedicineId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found"));

        PrescriptionMedicine pm = new PrescriptionMedicine();

        pm.setPrescription(prescription);
        pm.setMedicine(medicine);
        pm.setDosage(request.getDosage());
        pm.setFrequency(request.getFrequency());
        pm.setDurationDays(request.getDurationDays());
        pm.setInstructions(request.getInstructions());

        return repository.save(pm);
    }

    @Override
    public List<PrescriptionMedicine> getAll() {
        return repository.findAll();
    }

    @Override
    public PrescriptionMedicine getById(String id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription medicine not found"));
    }

    @Override
    public PrescriptionMedicine update(
            String id,
            PrescriptionMedicineRequest request) {

        PrescriptionMedicine pm = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription medicine not found"));

        Prescription prescription = prescriptionRepository
                .findById(request.getPrescriptionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription not found"));

        Medicine medicine = medicineRepository
                .findById(request.getMedicineId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found"));

        pm.setPrescription(prescription);
        pm.setMedicine(medicine);
        pm.setDosage(request.getDosage());
        pm.setFrequency(request.getFrequency());
        pm.setDurationDays(request.getDurationDays());
        pm.setInstructions(request.getInstructions());

        return repository.save(pm);
    }

    @Override
    public void delete(String id) {

        PrescriptionMedicine pm = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription medicine not found"));

        repository.delete(pm);
    }

    @Override
    public List<PrescriptionMedicine> searchByPrescription(String prescriptionId) {
        return repository.findByPrescription_Id(prescriptionId);
    }

    @Override
    public List<PrescriptionMedicine> searchByMedicine(String medicineId) {
        return repository.findByMedicine_Id(medicineId);
    }

    @Override
    public List<PrescriptionMedicine> searchByMedicineName(String name) {
        return repository.findByMedicine_NameContainingIgnoreCase(name);
    }

    @Override
    public List<PrescriptionMedicine> searchByFrequency(String frequency) {
        return repository.findByFrequencyIgnoreCase(frequency);
    }

    @Override
    public List<PrescriptionMedicine> searchByDuration(Integer duration) {
        return repository.findByDurationDays(duration);
    }

    @Override
    public Page<PrescriptionMedicine> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}