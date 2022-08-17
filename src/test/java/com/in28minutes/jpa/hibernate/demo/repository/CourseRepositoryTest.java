package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.Section5In28minutesApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Section5In28minutesApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById() {
        Course course = courseRepository.findById(10001L);
        assertEquals("jpaaa", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        courseRepository.deleteById(10001L);
        assertNull(null, courseRepository.findById(10001L));
    }

    @Test
    @DirtiesContext
    public void save() {
//        get course
        Course course = courseRepository.findById(10001L);
        assertEquals("jpaaa", course.getName());

//        update details
        course.setName("jpaaa - updated");
        courseRepository.save(course);

//        check the value
        course = courseRepository.findById(10001L);
        assertEquals("jpaaa - updated", course.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        courseRepository.playWithEntityManager();
    }

}
