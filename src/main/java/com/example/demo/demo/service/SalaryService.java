package com.example.demo.demo.service;



import com.example.demo.demo.model.Salary;

import java.util.List;

public interface SalaryService {
    Salary saveSalary(Salary salary);

    List<Salary> getAllSalary();

    Salary getSalaryById(long id);

    Salary updateSalary(Salary salary, long id);

    void deleteSalary(long id);
}
