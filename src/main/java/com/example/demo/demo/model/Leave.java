package com.example.demo.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leaveType;

    private String leaveStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveTo;

    private String leaveDescription;

    @ManyToOne
    private Employee employee;
}
