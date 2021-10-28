package com.camacode.jpa_depth_training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.camacode.jpa_depth_training.repository.CourseRepository;

@SpringBootApplication
public class JpaDepthTrainingApplication implements CommandLineRunner {

    @Autowired
    private  CourseRepository courseRepository;

    Logger logger = LoggerFactory.getLogger(JpaDepthTrainingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaDepthTrainingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Course (id = 1) ->{}",courseRepository.findById(1));
    }
}
