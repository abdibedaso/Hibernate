package com.geekcolab.development;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppBook {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Book.class));
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        /* 1---
        • Open a session
        • Create 3 books save them to the database
        • Close the session
         */

        // Create new instances of Book and set values in it
        Book book1 = new Book("Gang of Four Design Patterns",
                "9780201309515",
                "Erich Gamma, John Vlissides, Richard Helm, Ralph Johnson",
                55d,
                LocalDate.of(1994, 9, 21));
        Book book2 = new Book("Head First Design Patterns",
                "9781600330544",
                "Elisabeth Freeman, Kathy Sierra",
                50d,
                LocalDate.of(2004, 9, 1));
        Book book3 = new Book("Clean Code",
                "9780136083238",
                "Robert Cecil Martin",
                20d,
                LocalDate.of(2008, 8, 1));
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();


			// save the books
			session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            System.out.println("\n---- • Create 3 books save them to the database \n");

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        /* 2---
        • Open a session
        • Retrieve all books and output them to the console
        • Close the session
         */
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
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        /* 3---
        • Open a session
        • Retrieve a book from the database and change its title and price
        • Delete a book (not the one that was just updated)
        • Close the session
         */
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            System.out.println("\n---- • Retrieve a book from the database and change its title and price  ");
            System.out.println("---- • Delete a book (not the one that was just updated)   \n");

            // retrieve book1 and change its title and price
            Book book = session.get(Book.class, book1.getId());
            book.setPrice(60d);
            book.setTitle("EA");
            session.update(book);

            // Delete a book (not the one that was just updated)
            session.delete(book2);

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        /* 4---
        • Open a session
        • Retrieve all books and output them to the console
        • Close the session
         */
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // retrieve all books
            List<Book> books = session.createQuery("from Book", Book.class).list();
            System.out.println("\n---- • Retrieve all books and output them to the console  \n");
            for (Book book : books) {
                System.out.println(book);
            }
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("");

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
    }
}