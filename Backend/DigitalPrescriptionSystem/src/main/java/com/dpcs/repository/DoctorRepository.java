package com.dpcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,String> {

    boolean existsByLicenseNumber(String licenseNumber);

}