package com.upt.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "billing_system")
public class BillingSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalBedUsed; 
    private int totalSurgicalUsed; 
    private double totalEarnings; 

    public BillingSystem() {
        this.totalBedUsed = 0;
        this.totalSurgicalUsed = 0;
        this.totalEarnings = 0.0;
    }

    public void usarCama(double valueDaily) {
        totalBedUsed++;
        totalEarnings += valueDaily; 
    }

    public void usarSala(double valueDaily) {
        totalSurgicalUsed++;
        totalEarnings += valueDaily; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalBedUsed() {
        return totalBedUsed;
    }

    public void setTotalBedUsed(int totalBedUsed) {
        this.totalBedUsed = totalBedUsed;
    }

    public int getTotalSurgicalUsed() {
        return totalSurgicalUsed;
    }

    public void setTotalSalasUsadas(int totalSurgicalUsed) {
        this.totalSurgicalUsed = totalSurgicalUsed;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalGanhos(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
}
