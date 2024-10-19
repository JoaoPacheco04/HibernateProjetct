package com.upt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HospitalManagementSystem {
    protected SessionFactory sessionFactory;

    protected void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() 
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void createDoctor(Doctor doctor) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(doctor); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    protected void createPatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(patient); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    protected Doctor readDoctor(int id) {
        Doctor doctor = null;
        try (Session session = sessionFactory.openSession()) {
            doctor = session.get(Doctor.class, id); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }

    protected Patient readPatient(int id) {
        Patient patient = null;
        try (Session session = sessionFactory.openSession()) {
            patient = session.get(Patient.class, id); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    protected void updateDoctor(Doctor doctor) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(doctor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    protected void updatePatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    protected void deleteDoctor(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                session.delete(doctor);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    protected void deletePatient(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.delete(patient);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    protected void exit() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
