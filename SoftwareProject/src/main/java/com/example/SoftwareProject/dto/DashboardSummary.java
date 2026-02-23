package com.example.SoftwareProject.dto;

public class DashboardSummary {

    private long totalMedicines;
    private long lowStockCount;
    private long expiredCount;
    private long totalDispensedToday;

    public DashboardSummary(long totalMedicines,
                               long lowStockCount,
                               long expiredCount,
                               long totalDispensedToday) {
        this.totalMedicines = totalMedicines;
        this.lowStockCount = lowStockCount;
        this.expiredCount = expiredCount;
        this.totalDispensedToday = totalDispensedToday;
    }

    public long getTotalMedicines() {
        return totalMedicines;
    }

    public long getLowStockCount() {
        return lowStockCount;
    }

    public long getExpiredCount() {
        return expiredCount;
    }

    public long getTotalDispensedToday() {
        return totalDispensedToday;
    }
}

