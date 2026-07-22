package com.dpcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dpcs.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,String> {

    boolean existsByLicenseNumber(String licenseNumber);
    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);

    Doctor findByLicenseNumber(String licenseNumber);

    List<Doctor> findByYearsOfExperience(Integer yearsOfExperience);

    // Fee Search

    List<Doctor> findByConsultationFee(Double consultationFee);

    List<Doctor> findByConsultationFeeLessThanEqual(Double consultationFee);

    List<Doctor> findByConsultationFeeGreaterThanEqual(Double consultationFee);

    List<Doctor> findByConsultationFeeBetween(Double minFee, Double maxFee);

    List<Doctor> findByUserId(String userId);

}