package com.dpcs.dto;

import jakarta.validation.constraints.*;

public class DoctorRequest {

	 @NotBlank(message = "User Id is required")
	    private String userId;

	    @NotBlank(message = "Specialization is required")
	    private String specialization;

	    @NotBlank(message = "License Number is required")
	    private String licenseNumber;

	    @NotNull(message = "Experience is required")
	    @Min(value = 0, message = "Experience cannot be negative")
	    private Integer yearsOfExperience;

	    @NotNull(message = "Consultation Fee is required")
	    @Positive(message = "Fee must be greater than 0")
	    private Double consultationFee;
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
    
}