package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.PrescriptionItem;

public interface PrescriptionItemRepository
        extends JpaRepository<PrescriptionItem,String>{

}