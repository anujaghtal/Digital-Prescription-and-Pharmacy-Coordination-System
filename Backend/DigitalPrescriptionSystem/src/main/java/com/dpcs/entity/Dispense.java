package com.dpcs.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "dispenses")
public class Dispense {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false)
    private Pharmacy pharmacy;

    private LocalDateTime dispensedAt;

    private String remarks;

    @PrePersist
    public void prePersist() {

        id = UUID.randomUUID().toString();
        dispensedAt = LocalDateTime.now();

    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public LocalDateTime getDispensedAt() {
		return dispensedAt;
	}

	public void setDispensedAt(LocalDateTime dispensedAt) {
		this.dispensedAt = dispensedAt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    

}