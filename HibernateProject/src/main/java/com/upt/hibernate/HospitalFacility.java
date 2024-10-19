package com.upt.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital_facility")
public class HospitalFacility {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_beds")
    private int totalBeds;

    @Column(name = "occupied_beds")
    private int occupiedBeds;

    @Column(name = "total_surgical_rooms")
    private int totalSurgicalRooms;

    @Column(name = "occupied_surgical_rooms")
    private int occupiedSurgicalRooms;

    public HospitalFacility() {
    }

    public HospitalFacility(int totalBeds, int occupiedBeds, int totalSurgicalRooms, int occupiedSurgicalRooms) {
        this.totalBeds = totalBeds;
        this.occupiedBeds = occupiedBeds;
        this.totalSurgicalRooms = totalSurgicalRooms;
        this.occupiedSurgicalRooms = occupiedSurgicalRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public int getTotalSurgicalRooms() {
        return totalSurgicalRooms;
    }

    public void setTotalSurgicalRooms(int totalSurgicalRooms) {
        this.totalSurgicalRooms = totalSurgicalRooms;
    }

    public int getOccupiedSurgicalRooms() {
        return occupiedSurgicalRooms;
    }

    public void setOccupiedSurgicalRooms(int occupiedSurgicalRooms) {
        this.occupiedSurgicalRooms = occupiedSurgicalRooms;
    }

    public int getAvailableBeds() {
        return totalBeds - occupiedBeds;
    }

    public int getAvailableSurgicalRooms() {
        return totalSurgicalRooms - occupiedSurgicalRooms;
    }
}
