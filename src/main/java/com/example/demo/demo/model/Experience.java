package com.example.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String experienceYear;

    private String experienceType;

    private String ExperienceDescription;

    @ManyToOne
    private Employee employee;
}
