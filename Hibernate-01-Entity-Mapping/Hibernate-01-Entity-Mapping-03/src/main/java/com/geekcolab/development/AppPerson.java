package com.geekcolab.development;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppPerson {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Person.class));
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        /* 1---
        • Open a session
        • Retrieve all person objects from the database and print them to the console
        • Update a person, and delete another
        • Retrieve all person objects from the database and print them to the console
         */

        // Create new instances of Person and set values in it
        Person person1 = new Person(
                "Abdi",
                "Tufa",
                LocalDate.of(1996, 7, 19));
        Person person2 = new Person(
                "Segni",
                "Tufa",
                LocalDate.of(2000, 1, 1));
        Person person3 = new Person(
                "Beka",
                "Tufa",
                LocalDate.of(2005, 1, 1));
        try {
            //• Open a session
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

			// • Create / save 3 person objects
			session.persist(person1);
            session.persist(person2);
            session.persist(person3);

            System.out.println("\n• Create / save 3 person objects \n");

            //• Retrieve all person objects from the database and print them to the console
            List<Person> people = session.createQuery("from Person", Person.class).list();
            System.out.println("\n • Retrieve all person objects from the database and print them to the console \n");
            for (Person person : people) {
                System.out.println(person);
            }

            //• Update a person, and delete another
            person1.setFirstname("Hamziya");
            session.update(person1);
            session.delete(person2);

            System.out.println("\n • Update a person, and delete another  \n");

            //• Retrieve all person objects from the database and print them to the console
            people = session.createQuery("from Person", Person.class).list();
            System.out.println("\n • Retrieve all person objects from the database and print them to the console \n");
            for (Person person : people) {
                System.out.println(person);
            }

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
    }
}