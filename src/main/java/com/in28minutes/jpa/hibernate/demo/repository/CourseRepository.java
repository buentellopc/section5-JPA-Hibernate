package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CourseRepository {

    @Autowired
    EntityManager em;

//    find by id method
    public Course findById(Long id){
        return em.find(Course.class, id);
    }


}
