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
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    //Constructor
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    //public Appointment createAppointment(CreateUserDTO createUserDTO){} //TODO

    public Optional<Appointment> findByAppointmentid(Integer id){
        return appointmentRepository.findByAppointmentId(id);
    }

    public AppointmentRepository getAppointmentRepository() {
        return appointmentRepository;
    }

    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
}
