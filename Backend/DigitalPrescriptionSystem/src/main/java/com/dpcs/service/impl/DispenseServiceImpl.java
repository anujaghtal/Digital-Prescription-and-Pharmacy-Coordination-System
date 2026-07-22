package com.dpcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dpcs.dto.DispenseRequest;
import com.dpcs.entity.Dispense;
import com.dpcs.entity.Pharmacy;
import com.dpcs.entity.Prescription;
import com.dpcs.entity.PrescriptionItem;
import com.dpcs.repository.DispenseRepository;
import com.dpcs.repository.PharmacyRepository;
import com.dpcs.repository.PrescriptionItemRepository;
import com.dpcs.repository.PrescriptionRepository;
import com.dpcs.service.DispenseService;

@Service
public class DispenseServiceImpl implements DispenseService {

    private final DispenseRepository dispenseRepository;

    private final PrescriptionRepository prescriptionRepository;

    private final PharmacyRepository pharmacyRepository;

    private final PrescriptionItemRepository itemRepository;

    public DispenseServiceImpl(
            DispenseRepository dispenseRepository,
            PrescriptionRepository prescriptionRepository,
            PharmacyRepository pharmacyRepository,
            PrescriptionItemRepository itemRepository) {

        this.dispenseRepository = dispenseRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.itemRepository = itemRepository;

    }

    @Override
    public Dispense dispense(DispenseRequest request) {

        Prescription prescription =
                prescriptionRepository.findById(request.getPrescriptionId())
                        .orElseThrow(() ->
                                new RuntimeException("Prescription Not Found"));

        Pharmacy pharmacy =
                pharmacyRepository.findById(request.getPharmacyId())
                        .orElseThrow(() ->
                                new RuntimeException("Pharmacy Not Found"));

        List<PrescriptionItem> items = itemRepository.findAll();

        for(PrescriptionItem item : items){

            if(item.getPrescription().getId()
                    .equals(prescription.getId())){

                item.getMedicine().setStockQuantity(

                        item.getMedicine().getStockQuantity()-1

                );

            }

        }//or To make the stock update actually persist, inject MedicineRepository and save each updated medicine
        //medicineRepository.save(item.getMedicine());
        prescription.setStatus("DISPENSED");

        prescriptionRepository.save(prescription);

        Dispense dispense = new Dispense();

        dispense.setPrescription(prescription);

        dispense.setPharmacy(pharmacy);

        dispense.setRemarks(request.getRemarks());

        return dispenseRepository.save(dispense);

    }

    @Override
    public List<Dispense> getAll() {
        return dispenseRepository.findAll();
    }

    @Override
    public Dispense getById(String id) {

        return dispenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Dispense Record Not Found"));

    }
    @Override
    public Dispense update(String id, DispenseRequest request) {

        Dispense dispense = dispenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispense not found"));

        Prescription prescription = prescriptionRepository
                .findById(request.getPrescriptionId())
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        Pharmacy pharmacy = pharmacyRepository
                .findById(request.getPharmacyId())
                .orElseThrow(() -> new RuntimeException("Pharmacy not found"));

        dispense.setPrescription(prescription);
        dispense.setPharmacy(pharmacy);
        dispense.setRemarks(request.getRemarks());

        return dispenseRepository.save(dispense);
    }

    @Override
    public void delete(String id) {

        Dispense dispense = dispenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispense not found"));

        dispenseRepository.delete(dispense);
    }

}