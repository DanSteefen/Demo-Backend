package com.example.demo.demo.controller;


import com.example.demo.demo.model.Department;
import com.example.demo.demo.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public ResponseEntity<Department> saveCustomer(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartment();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long depId){
        return new ResponseEntity<Department>(departmentService.getDepartmentById(depId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id, @RequestBody Department department){

        return new ResponseEntity<Department>(departmentService.updateDepartment(department, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
        departmentService.deleteDepartment(id);

        return new ResponseEntity<String>("Department deleted successfully!.", HttpStatus.OK);
    }

}
