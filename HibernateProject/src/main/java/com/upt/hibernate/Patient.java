package com.upt.hibernate;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "patient")
public class Patient extends Person {

    @Column(name = "medical_history")
    @ElementCollection
    private List<String> medicalHistory;

    @Column(name = "requires_surgery")
    private boolean requiresSurgery;

    @Column(name = "bed_days")
    private int bedDays;

    @Column(name = "surgery_days")
    private int surgeryDays;
    
    @Column(name = "pescribed_Medicines")
    private Map<String, Integer> pescribedMedicines;

    public Patient(Long id, String name, int numberPhone, List<String> medicalHistory, boolean requiresSurgery, int bedDays, int surgeryDays) {
        super(id, name, numberPhone);
        this.medicalHistory = medicalHistory;
        this.requiresSurgery = requiresSurgery;
        this.bedDays = bedDays;
        this.surgeryDays = surgeryDays;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean isRequiresSurgery() {
        return requiresSurgery;
    }

    public void setRequiresSurgery(boolean requiresSurgery) {
        this.requiresSurgery = requiresSurgery;
    }

    public int getBedDays() {
        return bedDays;
    }

    public void setBedDays(int bedDays) {
        this.bedDays = bedDays;
    }

    public int getSurgeryDays() {
        return surgeryDays;
    }

    public void setSurgeryDays(int surgeryDays) {
        this.surgeryDays = surgeryDays;
    }
    
}

