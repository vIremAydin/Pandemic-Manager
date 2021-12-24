package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateAppointmentDTO;
import com.group1j.backend.entities.Appointment;
import com.group1j.backend.entities.DoctorAppointment;
import com.group1j.backend.entities.TestAppointment;
import com.group1j.backend.services.DoctorAppointmentService;
import com.group1j.backend.services.TestAppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
    //Fields
    private TestAppointmentService testAppointmentService;
    private DoctorAppointmentService doctorAppointmentService;

    //Constructor
    public AppointmentController(TestAppointmentService testAppointmentService, DoctorAppointmentService doctorAppointmentService) {
        this.testAppointmentService = testAppointmentService;
        this.doctorAppointmentService = doctorAppointmentService;
    }

    @PostMapping("/testAppointment/create")
    public TestAppointment createTestAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO){
        return testAppointmentService.createTestAppointment(createAppointmentDTO);
    }

    @PostMapping("/doctorAppointment/create")
    public DoctorAppointment createDoctorAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO){
        return doctorAppointmentService.createDoctorAppointment(createAppointmentDTO);
    }

    public TestAppointmentService getTestAppointmentService() {
        return testAppointmentService;
    }

    public void setTestAppointmentService(TestAppointmentService testAppointmentService) {
        this.testAppointmentService = testAppointmentService;
    }

    public DoctorAppointmentService getDoctorAppointmentService() {
        return doctorAppointmentService;
    }

    public void setDoctorAppointmentService(DoctorAppointmentService doctorAppointmentService) {
        this.doctorAppointmentService = doctorAppointmentService;
    }
}
