package com.upt.hibernate;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "pharmacy")
public class PharmacySystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "medicine_stock", joinColumns = @JoinColumn(name = "pharmacy_id"))
    @MapKeyColumn(name = "medicine_name")
    @Column(name = "quantity")
    private Map<String, Integer> stock = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "medicine_price", joinColumns = @JoinColumn(name = "pharmacy_id"))
    @MapKeyColumn(name = "medicine_name")
    @Column(name = "price")
    private Map<String, Double> prices = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "medicines_sold", joinColumns = @JoinColumn(name = "pharmacy_id"))
    @MapKeyColumn(name = "medicine_name")
    @Column(name = "quantity_sold")
    private Map<String, Integer> medicinesSold = new HashMap<>();

    public PharmacySystem() {
    }

    public void addMedicine(String medicineName, int quantity, double price) {
        stock.put(medicineName, stock.getOrDefault(medicineName, 0) + quantity);
        prices.put(medicineName, price);
    }

    public boolean dispenseMedicine(String medicineName, int quantity) {
        if (stock.containsKey(medicineName) && stock.get(medicineName) >= quantity) {
            stock.put(medicineName, stock.get(medicineName) - quantity);
            medicinesSold.put(medicineName, medicinesSold.getOrDefault(medicineName, 0) + quantity);
            return true; 
        }
        return false;
    }

    public int getStock(String medicineName) {
        return stock.getOrDefault(medicineName, 0);
    }

    public double getPrice(String medicineName) {
        return prices.getOrDefault(medicineName, 0.0);
    }

    public int getTotalMedicinesSold() {
        return medicinesSold.values().stream().mapToInt(Integer::intValue).sum();
    }

    public Map<String, Integer> getMedicinesSold() {
        return medicinesSold;
    }
}
