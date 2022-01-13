package com.example.demo.demo.service.serviceImple;

import com.example.demo.demo.exception.ResourceNotFoundException;
import com.example.demo.demo.model.Attendance;
import com.example.demo.demo.repository.AttendanceRepository;
import com.example.demo.demo.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(long id) {
        return attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance", "Id", id));
    }

    @Override
    public Attendance updateAttendance(Attendance attendance, long id) {
        Attendance currentAttendance = attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance", "Id", id));

        currentAttendance.setAttendanceType(attendance.getAttendanceType());
        currentAttendance.setAttendanceDescription(attendance.getAttendanceDescription());

        attendanceRepository.save(currentAttendance);
        return currentAttendance;
    }

    @Override
    public void deleteAttendance(long id) {

        attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance", "Id", id));

        attendanceRepository.deleteById(id);

    }
}
