package com.geekcolab.development.e;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="book_id")
    private Book book;

    public Reservation(LocalDate date) {
        this.date = date;
    }

    private void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "date=" + date +
                ", book=" + book +
                '}';
    }
}