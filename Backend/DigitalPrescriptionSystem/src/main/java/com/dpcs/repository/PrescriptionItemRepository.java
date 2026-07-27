package com.dpcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.PrescriptionItem;

public interface PrescriptionItemRepository
        extends JpaRepository<PrescriptionItem,String>{
	List<PrescriptionItem> findByPrescription_Id(String prescriptionId);

}