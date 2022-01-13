package com.example.demo.demo.service.serviceImple;


import com.example.demo.demo.exception.ResourceNotFoundException;
import com.example.demo.demo.model.Employee;
import com.example.demo.demo.repository.EmployeeRepository;
import com.example.demo.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee currentEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

        currentEmployee.setName(employee.getName());
        currentEmployee.setAddress(employee.getAddress());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setPhone(employee.getPhone());

        employeeRepository.save(currentEmployee);

        return currentEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));

        employeeRepository.deleteById(id);
    }
}
