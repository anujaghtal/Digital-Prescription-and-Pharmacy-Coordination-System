package com.dpcs.dto;

public class DoctorDashboardResponse {

    private long todayAppointments;
    private long totalPatients;
    private long prescriptionsWritten;

    public DoctorDashboardResponse() {
    }

    public DoctorDashboardResponse(long todayAppointments,
                                   long totalPatients,
                                   long prescriptionsWritten) {
        this.todayAppointments = todayAppointments;
        this.totalPatients = totalPatients;
        this.prescriptionsWritten = prescriptionsWritten;
    }

    public long getTodayAppointments() {
        return todayAppointments;
    }

    public void setTodayAppointments(long todayAppointments) {
        this.todayAppointments = todayAppointments;
    }

    public long getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(long totalPatients) {
        this.totalPatients = totalPatients;
    }

    public long getPrescriptionsWritten() {
        return prescriptionsWritten;
    }

    public void setPrescriptionsWritten(long prescriptionsWritten) {
        this.prescriptionsWritten = prescriptionsWritten;
    }
}