package com.dpcs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.Pharmacy;

public interface PharmacyRepository
        extends JpaRepository<Pharmacy,String>{

    boolean existsByLicenseNumber(String licenseNumber);

    Optional<Pharmacy> findByLicenseNumber(String licenseNumber);

}