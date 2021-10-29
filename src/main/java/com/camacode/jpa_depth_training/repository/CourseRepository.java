package com.camacode.jpa_depth_training.repository;

import com.camacode.jpa_depth_training.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long idCourse) {
        return entityManager.find(Course.class, idCourse);
    }

    // insert or update
    public Course save(Course course){
        if(course.getId()==null){
            entityManager.persist(course);
        }else{
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    public void playWithEntityManager(){
        Course course = new Course("microservices with spring boot");
        entityManager.persist(course);
        //send the changement to the data base
        entityManager.flush();
        course.setName("microservices with spring boot - Update");
        entityManager.flush();

        Course course2 = new Course("Angular with spring boot");
        entityManager.persist(course2);
        entityManager.flush();
        //detach entity from the entity manage : any modification to the entity course2 will not applied

        entityManager.detach(course2);
        course.setName("Angular with spring boot - Update");
        //detach all entity from the entity manager
        entityManager.clear();

    }
}
