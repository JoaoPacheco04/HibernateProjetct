package com.upt.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private int daysInBed; 
    private int daysInSurgicalRoom; 


    public Treatment() {
    }

    public Treatment(Patient patient, int daysInBed, int daysInSurgicalRoom) {
        this.patient = patient;
        this.daysInBed = daysInBed;
        this.daysInSurgicalRoom = daysInSurgicalRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getDaysInBed() {
        return daysInBed;
    }

    public void setDaysInBed(int daysInBed) {
        this.daysInBed = daysInBed;
    }

    public int getDaysInSurgicalRoom() {
        return daysInSurgicalRoom;
    }

    public void setDaysInSurgicalRoom(int daysInSurgicalRoom) {
        this.daysInSurgicalRoom = daysInSurgicalRoom;
    }

    public double calculateCost(double bedCostPerDay, double surgicalRoomCostPerDay) {
        return (daysInBed * bedCostPerDay) + (daysInSurgicalRoom * surgicalRoomCostPerDay);
    }
}
