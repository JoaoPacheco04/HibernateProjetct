package com.upt.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Manager {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public Manager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addDoctor(Doctor doctor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(doctor);
            entityManager.getTransaction().commit();
            System.out.println("Doctor added successfully: " + doctor.getName());
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Error adding doctor: " + e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}

