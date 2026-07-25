package com.dpcs.dto;

public class ReportResponse {

    private long totalAppointments;
    private long completedAppointments;
    private long pendingAppointments;
    private long cancelledAppointments;

    private long totalDoctors;
    private long totalPatients;

    private long totalMedicines;
    private long totalPrescriptions;
    private long totalDispensed;

    public ReportResponse() {
    }

    public ReportResponse(
            long totalAppointments,
            long completedAppointments,
            long pendingAppointments,
            long cancelledAppointments,
            long totalDoctors,
            long totalPatients,
            long totalMedicines,
            long totalPrescriptions,
            long totalDispensed) {

        this.totalAppointments = totalAppointments;
        this.completedAppointments = completedAppointments;
        this.pendingAppointments = pendingAppointments;
        this.cancelledAppointments = cancelledAppointments;
        this.totalDoctors = totalDoctors;
        this.totalPatients = totalPatients;
        this.totalMedicines = totalMedicines;
        this.totalPrescriptions = totalPrescriptions;
        this.totalDispensed = totalDispensed;
    }

    public long getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(long totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public long getCompletedAppointments() {
        return completedAppointments;
    }

    public void setCompletedAppointments(long completedAppointments) {
        this.completedAppointments = completedAppointments;
    }

    public long getPendingAppointments() {
        return pendingAppointments;
    }

    public void setPendingAppointments(long pendingAppointments) {
        this.pendingAppointments = pendingAppointments;
    }

    public long getCancelledAppointments() {
        return cancelledAppointments;
    }

    public void setCancelledAppointments(long cancelledAppointments) {
        this.cancelledAppointments = cancelledAppointments;
    }

    public long getTotalDoctors() {
        return totalDoctors;
    }

    public void setTotalDoctors(long totalDoctors) {
        this.totalDoctors = totalDoctors;
    }

    public long getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(long totalPatients) {
        this.totalPatients = totalPatients;
    }

    public long getTotalMedicines() {
        return totalMedicines;
    }

    public void setTotalMedicines(long totalMedicines) {
        this.totalMedicines = totalMedicines;
    }

    public long getTotalPrescriptions() {
        return totalPrescriptions;
    }

    public void setTotalPrescriptions(long totalPrescriptions) {
        this.totalPrescriptions = totalPrescriptions;
    }

    public long getTotalDispensed() {
        return totalDispensed;
    }

    public void setTotalDispensed(long totalDispensed) {
        this.totalDispensed = totalDispensed;
    }
}