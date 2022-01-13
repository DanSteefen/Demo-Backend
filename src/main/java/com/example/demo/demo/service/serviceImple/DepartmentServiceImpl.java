package com.example.demo.demo.service.serviceImple;

import com.example.demo.demo.exception.ResourceNotFoundException;
import com.example.demo.demo.model.Department;
import com.example.demo.demo.repository.DepartmentRepository;
import com.example.demo.demo.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department );
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
    }

    @Override
    public Department updateDepartment(Department department, long id) {
        Department currentDepartment = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));

        currentDepartment.setTitle(department.getTitle());
        currentDepartment.setDescription(department.getDescription());

        departmentRepository.save(currentDepartment);

        return currentDepartment;
    }

    @Override
    public void deleteDepartment(long id) {

        departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

        departmentRepository.deleteById(id);
    }
}
