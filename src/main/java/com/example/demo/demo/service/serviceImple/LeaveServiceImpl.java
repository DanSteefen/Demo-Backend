package com.example.demo.demo.service.serviceImple;

import com.example.demo.demo.exception.ResourceNotFoundException;
import com.example.demo.demo.model.Leave;
import com.example.demo.demo.repository.LeaveRepository;
import com.example.demo.demo.service.LeaveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    private LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getAllLeave() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave getLeaveById(long id) {
        return leaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));
    }

    @Override
    public Leave updateLeave(Leave leave, long id) {
        Leave currentLeave = leaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));

        currentLeave.setLeaveType(leave.getLeaveType());
        currentLeave.setLeaveStatus(leave.getLeaveStatus());
        currentLeave.setLeaveFrom(leave.getLeaveFrom());
        currentLeave.setLeaveTo(leave.getLeaveTo());
        currentLeave.setLeaveDescription(leave.getLeaveDescription());

        leaveRepository.save(currentLeave);

        return currentLeave;
    }

    @Override
    public void deleteLeave(long id) {

        leaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));

        leaveRepository.deleteById(id);
    }
}
