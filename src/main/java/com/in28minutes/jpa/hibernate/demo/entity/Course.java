package com.in28minutes.jpa.hibernate.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "query_get_all_courses", query = "Select c from Course c"),
                @NamedQuery(name = "query_last100", query = "Select  c  From Course c where name like '%100 Steps'")
        }
)
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @CreationTimestamp
    private LocalDateTime createdDate;


    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;


    public Course() {

    }

    public Course(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
