package com.example.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String salaryAmount;

   private String salaryTotal;

   private String salaryType;

   private String salaryDescription;
}
