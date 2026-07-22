package com.dpcs.dto;

public class PharmacyDashboardResponse {

    private long pendingPrescriptions;
    private long dispensedToday;
    private long lowStockMedicines;

    public PharmacyDashboardResponse() {
    }

    public PharmacyDashboardResponse(long pendingPrescriptions,
                                     long dispensedToday,
                                     long lowStockMedicines) {
        this.pendingPrescriptions = pendingPrescriptions;
        this.dispensedToday = dispensedToday;
        this.lowStockMedicines = lowStockMedicines;
    }

    public long getPendingPrescriptions() {
        return pendingPrescriptions;
    }

    public void setPendingPrescriptions(long pendingPrescriptions) {
        this.pendingPrescriptions = pendingPrescriptions;
    }

    public long getDispensedToday() {
        return dispensedToday;
    }

    public void setDispensedToday(long dispensedToday) {
        this.dispensedToday = dispensedToday;
    }

    public long getLowStockMedicines() {
        return lowStockMedicines;
    }

    public void setLowStockMedicines(long lowStockMedicines) {
        this.lowStockMedicines = lowStockMedicines;
    }
}