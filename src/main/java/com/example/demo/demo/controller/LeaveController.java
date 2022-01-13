package com.example.demo.demo.controller;

import com.example.demo.demo.model.Leave;
import com.example.demo.demo.service.LeaveService;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/leaves")
public class LeaveController {

    private LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping()
    public ResponseEntity<Leave> saveExperience(@RequestBody Leave leave){
        return new ResponseEntity<>(leaveService.saveLeave(leave), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Leave> getAllExperiences(){
        return leaveService.getAllLeave();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Leave> getExperienceByID(@PathVariable("id") long levId){

        return new ResponseEntity<Leave>(leaveService.getLeaveById(levId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Leave> updateExperience(@PathVariable("id") long id, @RequestBody Leave leave){
        return new ResponseEntity<Leave>(leaveService.updateLeave(leave, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
        leaveService.deleteLeave(id);

        return new ResponseEntity<String>("Leave deleted successfully!.", HttpStatus.OK);
    }
}
