package com.geekcolab.development.d;

import com.geekcolab.development.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final SessionFactory sessionFactory;
    
    static {
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Customer.class, Reservation.class));
	}

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Customer customer = new Customer("Abdi");
            session.persist(customer);

            Reservation reservation = new Reservation(LocalDate.now());

            customer.addReservation(reservation);

            session.persist(reservation);

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

            List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
            System.out.println("\n---- • Retrieve all customers and output them to the console  \n");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            System.out.println("\n");


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
