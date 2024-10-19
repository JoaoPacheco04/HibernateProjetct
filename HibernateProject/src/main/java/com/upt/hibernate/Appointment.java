package com.upt.hibernate;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor; 

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient; 

    private LocalDateTime dateTime; 

    @Enumerated(EnumType.STRING)
    private Shift shift; 

    public enum Shift {
        MANHA,
        TARDE,
        NOITE
    }

    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime, Shift shift) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
