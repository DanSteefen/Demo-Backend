package com.example.demo.demo.service.serviceImple;

import com.example.demo.demo.exception.ResourceNotFoundException;
import com.example.demo.demo.model.Salary;
import com.example.demo.demo.repository.SalaryRepository;
import com.example.demo.demo.service.SalaryService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> getAllSalary() {
        return salaryRepository.findAll();
    }

    @Override
    public Salary getSalaryById(long id) {
        return salaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));
    }

    @Override
    public Salary updateSalary(Salary salary, long id) {
        Salary currentSalary = salaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));

        currentSalary.setSalaryAmount(salary.getSalaryAmount());
        currentSalary.setSalaryTotal(salary.getSalaryTotal());
        currentSalary.setSalaryType(salary.getSalaryType());
        currentSalary.setSalaryDescription(salary.getSalaryDescription());

        salaryRepository.save(currentSalary);
        return currentSalary;
    }

    @Override
    public void deleteSalary(long id) {

        salaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));

        salaryRepository.deleteById(id);
    }
}
