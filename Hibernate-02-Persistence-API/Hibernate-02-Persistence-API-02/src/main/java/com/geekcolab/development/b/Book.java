package com.geekcolab.development.b;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Book")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    private LocalDate publish_date;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinTable(name="book_publisher")
    private Publisher publisher;

    public Book(String title, String ISBN, String author, double price, LocalDate publish_date, Publisher publisher) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
        this.publisher = publisher;
    }

    private void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publish_date=" + publish_date +
                ", publisher=" + publisher +
                '}';
    }

}