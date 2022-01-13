package com.example.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table()
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;

    private String phone;

    @OneToOne
    private Salary salary;

    @ManyToOne
    private Department department;


}
