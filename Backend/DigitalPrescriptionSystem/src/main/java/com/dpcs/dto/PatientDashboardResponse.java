package com.dpcs.dto;

public class PatientDashboardResponse {

    private long upcomingAppointments;
    private long activePrescriptions;
    private long prescriptionHistory;

    public PatientDashboardResponse() {
    }

    public PatientDashboardResponse(long upcomingAppointments,
                                    long activePrescriptions,
                                    long prescriptionHistory) {
        this.upcomingAppointments = upcomingAppointments;
        this.activePrescriptions = activePrescriptions;
        this.prescriptionHistory = prescriptionHistory;
    }

    public long getUpcomingAppointments() {
        return upcomingAppointments;
    }

    public void setUpcomingAppointments(long upcomingAppointments) {
        this.upcomingAppointments = upcomingAppointments;
    }

    public long getActivePrescriptions() {
        return activePrescriptions;
    }

    public void setActivePrescriptions(long activePrescriptions) {
        this.activePrescriptions = activePrescriptions;
    }

    public long getPrescriptionHistory() {
        return prescriptionHistory;
    }

    public void setPrescriptionHistory(long prescriptionHistory) {
        this.prescriptionHistory = prescriptionHistory;
    }
}