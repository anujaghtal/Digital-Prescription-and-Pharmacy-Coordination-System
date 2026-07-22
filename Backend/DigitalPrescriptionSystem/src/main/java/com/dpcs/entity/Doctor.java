package com.dpcs.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="doctors")
public class Doctor {

    @Id
    private String id;

    @Column(name="user_id", nullable=false)
    private String userId;

    @Column(nullable=false)
    private String specialization;

    @Column(name="license_number", nullable=false, unique=true)
    private String licenseNumber;

    @Column(name="years_of_experience")
    private Integer yearsOfExperience;

    @Column(name="consultation_fee")
    private Double consultationFee;

    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private Boolean active = true;
    
    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID().toString();
        createdAt = LocalDateTime.now();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

 
    
}