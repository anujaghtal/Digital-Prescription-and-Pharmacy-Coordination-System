package com.dpcs.dto;

public class AdminDashboardResponse {

    private long totalUsers;
    private long totalDoctors;
    private long totalPatients;
    private long totalMedicines;
    private long totalPrescriptions;
    private long totalDispensed;

    public AdminDashboardResponse() {
    }

    public AdminDashboardResponse(
            long totalUsers,
            long totalDoctors,
            long totalPatients,
            long totalMedicines,
            long totalPrescriptions,
            long totalDispensed) {

        this.totalUsers = totalUsers;
        this.totalDoctors = totalDoctors;
        this.totalPatients = totalPatients;
        this.totalMedicines = totalMedicines;
        this.totalPrescriptions = totalPrescriptions;
        this.totalDispensed = totalDispensed;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
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