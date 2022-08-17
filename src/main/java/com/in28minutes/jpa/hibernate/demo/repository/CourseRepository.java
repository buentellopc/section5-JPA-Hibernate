package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/*

sdf

 */

@Transactional
@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());



    //    find by id method
    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
        }

        public void playWithEntityManager(){
            logger.info("playWithEntityManager - start");

//            Create the courses
            Course course1 = new Course("new course, playing with this");
            Course course2 = new Course("angular js in 100 steps");

//            persist (fire hibernate sequence to add an id) the courses (entity manager will now keep track of any changes)
            em.persist(course1);
            em.persist(course2);

//            save changes to database before end of transaction
            em.flush();

//            change both courses names
            course1.setName("updating the same course, without explicitly saving it!");
            course2.setName("angular js in 100 steps - updated");

//            retrieve the actual value of course1 from database
//            any new changes will be lost
//            em.refresh(course1);

//            course2 will have the new changes saved
            em.flush();

        }


}
