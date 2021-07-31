package com.geekcolab.development.c;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;

    @ManyToMany
    @JoinTable(name = "Student_Courses",
            joinColumns = { @JoinColumn(name = "Student_id") },
            inverseJoinColumns = { @JoinColumn(name = "courses_id") }
    )
    private List<Course> courses = new ArrayList();

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    private void setId(long id) {
        this.id = id;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", courses=" + courses +
                '}';
    }
}