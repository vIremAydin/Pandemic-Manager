package com.group1j.backend.controllers;

import com.group1j.backend.entities.Attendance;
import com.group1j.backend.services.AttendanceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/attendance")
public class AttendanceController {
    //Fields
    private AttendanceService attendanceService;

    //Constructor
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/add/student/{attendanceID}/{studentID}")
    public Attendance addStudent(@PathVariable int attendanceID, @PathVariable int studentID){
        return attendanceService.addStudent(attendanceID,studentID);
    }

    public AttendanceService getAttendanceService() {
        return attendanceService;
    }

    public void setAttendanceService(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
}
