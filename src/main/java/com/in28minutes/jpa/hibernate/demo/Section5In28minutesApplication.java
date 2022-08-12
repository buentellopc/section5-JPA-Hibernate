package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

// remember to implement command line runner
// remember to specify an entity manager class with the annotation of repository

@SpringBootApplication
public class Section5In28minutesApplication implements CommandLineRunner {
    @Autowired
    private CourseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Section5In28minutesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = repository.findById(10001L);
    }
}
