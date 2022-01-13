package com.example.demo.demo.service;



import com.example.demo.demo.model.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance saveAttendance(Attendance attendance);

    List<Attendance> getAllAttendance();

    Attendance getAttendanceById(long id);

    Attendance updateAttendance(Attendance attendance , long id);

    void deleteAttendance(long id);
}
