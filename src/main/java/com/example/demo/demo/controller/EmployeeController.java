package com.example.demo.demo.controller;

import com.example.demo.demo.model.Employee;
import com.example.demo.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    ********************build create employee RestApi**********************
    @PostMapping()
    public ResponseEntity<Employee> saveCustomer(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }

    //    ********************build getAll employee RestApi**********************
    @GetMapping
    public List<Employee> getAllCustomers(){
        return employeeService.getAllEmployees();
    }

    //    ********************build getEmployeeById RestApi**********************
    //    ********************http://localhost:8080/api/employees/1**********************
    @RequestMapping("{id}")
    public ResponseEntity<Employee> getCustomerById(@PathVariable("id") long empId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId), HttpStatus.OK);
    }

    //    ********************build update customer RestApi**********************
    //    ********************http://localhost:8080/api/employees/1**********************
    @PutMapping
    public ResponseEntity<Employee> updateCustomer(@PathVariable("id") long id, @RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //    ********************build delete customer RestApi**********************
    //    ********************http://localhost:8080/api/customers/1**********************
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Customer deleted successfully!.", HttpStatus.OK);
    }
}
