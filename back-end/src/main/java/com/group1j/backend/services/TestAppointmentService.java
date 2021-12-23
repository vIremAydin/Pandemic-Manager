package com.group1j.backend.services;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestAppointmentService {

    private TestAppointmentRepository testAppointmentRepository;

    //Constructor
    public TestAppointmentService(TestAppointmentRepository testAppointmentRepository) {
        this.testAppointmentRepository = testAppointmentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<TestAppointment> getAllTestAppointments(){
        return testAppointmentRepository.findAll();
    }

    //public Appointment createAppointment(CreateUserDTO createUserDTO){} //TODO

    public Optional<TestAppointment> findByAppointmentid(Integer id){
        return testAppointmentRepository.findByAppointmentID(id);
    }

    public TestAppointmentRepository getTestAppointmentRepository() {
        return testAppointmentRepository;
    }

    public void setTestAppointmentRepository(TestAppointmentRepository testAppointmentRepository) {
        this.testAppointmentRepository = testAppointmentRepository;
    }

}
