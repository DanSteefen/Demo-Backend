package com.example.demo.demo.service;

import com.example.demo.demo.model.Department;


import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartmentById(Long id);

    Department updateDepartment(Department department, long id);

    void deleteDepartment(long id);
}
