package com.dpcs.service;

import java.util.List;

import com.dpcs.dto.PrescriptionItemRequest;
import com.dpcs.entity.PrescriptionItem;

public interface PrescriptionItemService {

    PrescriptionItem save(PrescriptionItemRequest request);

    List<PrescriptionItem> getAll();
    //List<PrescriptionItem> findByPrescription_Id(String prescriptionId);

    PrescriptionItem getById(String id);

    void delete(String id);
    

}