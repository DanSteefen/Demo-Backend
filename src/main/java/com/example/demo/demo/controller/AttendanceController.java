package com.example.demo.demo.controller;


import com.example.demo.demo.model.Attendance;
import com.example.demo.demo.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attendance")
public class AttendanceController {

    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping()
    public ResponseEntity<Attendance> saveCustomer(@RequestBody Attendance attendance){
        return new ResponseEntity<>(attendanceService.saveAttendance(attendance), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Attendance> getAllCustomers(){
        return attendanceService.getAllAttendance();
    }

    @RequestMapping("{id}")
    public ResponseEntity<Attendance> getCustomerById(@PathVariable("id") long attId){
        return new ResponseEntity<Attendance>(attendanceService.getAttendanceById(attId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Attendance> updateCustomer(@PathVariable("id") long id, @RequestBody Attendance attendance){

        return new ResponseEntity<Attendance>(attendanceService.updateAttendance(attendance, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
        attendanceService.deleteAttendance(id);

        return new ResponseEntity<String>("Attendance deleted successfully!.", HttpStatus.OK);
    }
}
