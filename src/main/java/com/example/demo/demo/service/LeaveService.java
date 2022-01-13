package com.example.demo.demo.service;

import com.example.demo.demo.model.Leave;

import java.util.List;

public interface LeaveService {
    Leave saveLeave(Leave leave);

    List<Leave> getAllLeave();

    Leave getLeaveById(long id);

    Leave updateLeave(Leave leave, long id);

    void deleteLeave(long id);
}
