package com.example.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
}

