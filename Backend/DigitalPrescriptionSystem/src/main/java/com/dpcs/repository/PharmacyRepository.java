package com.dpcs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.Pharmacy;

public interface PharmacyRepository
        extends JpaRepository<Pharmacy,String>{

    boolean existsByLicenseNumber(String licenseNumber);

    Pharmacy findByLicenseNumber(String licenseNumber);

    List<Pharmacy> findByNameContainingIgnoreCase(String name);

    List<Pharmacy> findByOwnerNameContainingIgnoreCase(String ownerName);

    List<Pharmacy> findByEmailContainingIgnoreCase(String email);

    List<Pharmacy> findByPhoneContainingIgnoreCase(String phone);

    List<Pharmacy> findByAddressContainingIgnoreCase(String address);

    List<Pharmacy> findByActive(Boolean active);

    Page<Pharmacy> findAll(Pageable pageable);
}