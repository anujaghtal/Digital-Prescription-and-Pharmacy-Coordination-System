package com.dpcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dpcs.dto.PrescriptionItemRequest;
import com.dpcs.entity.Medicine;
import com.dpcs.entity.Prescription;
import com.dpcs.entity.PrescriptionItem;
import com.dpcs.exception.ResourceNotFoundException;
import com.dpcs.repository.MedicineRepository;
import com.dpcs.repository.PrescriptionItemRepository;
import com.dpcs.repository.PrescriptionRepository;
import com.dpcs.service.PrescriptionItemService;

@Service
public class PrescriptionItemServiceImpl
        implements PrescriptionItemService {

    private final PrescriptionItemRepository itemRepository;

    private final PrescriptionRepository prescriptionRepository;

    private final MedicineRepository medicineRepository;

    public PrescriptionItemServiceImpl(
            PrescriptionItemRepository itemRepository,
            PrescriptionRepository prescriptionRepository,
            MedicineRepository medicineRepository) {

        this.itemRepository = itemRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public PrescriptionItem save(PrescriptionItemRequest request) {

        Prescription prescription =
                prescriptionRepository.findById(request.getPrescriptionId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Prescription not found"));

        Medicine medicine =
                medicineRepository.findById(request.getMedicineId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Medicine not found"));

        PrescriptionItem item = new PrescriptionItem();

        item.setPrescription(prescription);
        item.setMedicine(medicine);

        item.setDosage(request.getDosage());
        item.setFrequency(request.getFrequency());
        item.setDurationDays(request.getDurationDays());
        item.setInstructions(request.getInstructions());

        return itemRepository.save(item);
    }

    @Override
    public List<PrescriptionItem> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public PrescriptionItem getById(String id) {
        return itemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription Item not found"));
    }

    @Override
    public void delete(String id) {
        itemRepository.deleteById(id);
    }

}