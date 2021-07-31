package com.geekcolab.development.b;

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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Book.class, Publisher.class));
	}

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Publisher publisher = new Publisher("IOT");

            Book book1 = new Book("Gang of Four Design Patterns",
                    "9780201309515",
                    "Erich Gamma, John Vlissides, Richard Helm, Ralph Johnson",
                    55d,
                    LocalDate.of(1994, 9, 21),
                    publisher);

            session.persist(book1);

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


            // retrieve all books
            List<Book> books = session.createQuery("from Book", Book.class).list();
            System.out.println("\n---- • Retrieve all books and output them to the console  \n");
            for (Book book : books) {
                System.out.println(book);
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
