package com.camacode.jpa_depth_training.repository;

import com.camacode.jpa_depth_training.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long idCourse) {
        return entityManager.find(Course.class, idCourse);
    }

    //save => insert or update
//    public long save(Course course){
//        return entityManager .
//    }
}
