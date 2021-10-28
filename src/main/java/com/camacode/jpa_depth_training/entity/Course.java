package com.camacode.jpa_depth_training.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
