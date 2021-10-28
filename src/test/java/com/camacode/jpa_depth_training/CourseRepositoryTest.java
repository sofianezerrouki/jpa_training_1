package com.camacode.jpa_depth_training;

import com.camacode.jpa_depth_training.entity.Course;
import com.camacode.jpa_depth_training.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDepthTrainingApplication.class)
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;
    Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);
    @Test
    @DirtiesContext // after this test is run , Spring will automatiquely RESET the data ,for other tests : data not change at all :)
    public void deleteById_basic(){
        courseRepository.deleteById(102);
        assertNull(courseRepository.findById(102L));
    }
    @Test
    public void findById_basic(){
        Course course = courseRepository.findById(102);
        assertEquals("Hibernate and JDBC",course.getName());
    }

}
