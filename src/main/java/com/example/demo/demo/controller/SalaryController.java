package com.example.demo.demo.controller;

import com.example.demo.demo.model.Salary;
import com.example.demo.demo.service.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/salaries")
public class SalaryController {

    private SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping()
    public ResponseEntity<Salary> saveSalary(@RequestBody Salary salary){
        return new ResponseEntity<>(salaryService.saveSalary(salary), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Salary> getAllSalaries(){
        return salaryService.getAllSalary();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Salary> getSalaryByID(@PathVariable("id") long salId){

        return new ResponseEntity<Salary>(salaryService.getSalaryById(salId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Salary> updateSalary(@PathVariable("id") long id, @RequestBody Salary salary){
        return new ResponseEntity<Salary>(salaryService.updateSalary(salary, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSalary(@PathVariable("id") long id){
        salaryService.deleteSalary(id);

        return new ResponseEntity<String>("Salary deleted successfully!.", HttpStatus.OK);
    }
}
