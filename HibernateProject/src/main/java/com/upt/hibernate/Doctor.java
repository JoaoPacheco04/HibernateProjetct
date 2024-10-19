package com.upt.hibernate;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends Person {

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "available_shifts")
    @ElementCollection
    private List<String> availableShifts;

    public Doctor(Long id, String name, int numberPhone, String specialization, List<String> availableShifts) {
        super(id, name, numberPhone);
        this.specialization = specialization;
        this.availableShifts = availableShifts;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getAvailableShifts() {
        return availableShifts;
    }

    public void setAvailableShifts(List<String> availableShifts) {
        this.availableShifts = availableShifts;
    }
}
