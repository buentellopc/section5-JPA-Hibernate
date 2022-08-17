package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Section5In28minutesApplication.class)
public class Section5In28minutesApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void contextLoads() {
        logger.info("Testing is running fjsljfdjflkdsfjdslfjskjfklsdfjdkjsjkfls");
    }

    @Test
    public void findById(){
        Course course = courseRepository.findById(10001L);
        assertEquals("j",course.getName());
    }

}
