package com.geekcolab.development;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class App {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Owner.class, Car.class));
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Owner owner1 = new Owner("Abdi", "Fairfield");

            // creates two cars
            System.out.println("Step 1");
            // Create new instance of Car and set values in it
            Car car1 = new Car("AUDI", "2020", 30221.00);
            // Create new instance of Car and set values in it
            Car car2 = new Car("TOYOTA", "2022", 35880.00);

            // associates an owner with each one before persisting it
            System.out.println("Step 2");
            car1.setOwner(owner1);
            car2.setOwner(owner1);

            // save the car
            System.out.println("Step 3");
            session.persist(car1);
            session.persist(car2);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            System.out.println("Step 4");
            //Retrieve all cars
            List<Car> carList = session.createQuery("from Car").list();
            for (Car car : carList) {
                System.out.println(car);
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
}
