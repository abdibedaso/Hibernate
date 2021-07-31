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
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String courseNumber;
    private String name;

    @ManyToMany(mappedBy="courses")
    private List<Student> students = new ArrayList();

    public Course(String courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;
    }

    private void setId(long id) {
        this.id = id;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseNumber='" + courseNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}