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
        return entityManager.merge(course);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
