package com.example.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attendanceType;

    private String attendanceDescription;

    @ManyToOne
    private Employee employee;
}
