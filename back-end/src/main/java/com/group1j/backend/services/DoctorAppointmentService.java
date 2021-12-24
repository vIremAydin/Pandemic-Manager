package com.group1j.backend.services;

import com.group1j.backend.dto.CreateAppointmentDTO;
import com.group1j.backend.dto.CreateCourseDTO;
import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorAppointmentService {

    private DoctorAppointmentRepository doctorAppointmentRepository;

    //Constructor
    public DoctorAppointmentService(DoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<DoctorAppointment> getAllDoctorAppointments(){
        return doctorAppointmentRepository.findAll();
    }

    public Optional<DoctorAppointment> findByAppointmentid(Integer id){
        return doctorAppointmentRepository.findByAppointmentID(id);
    }

    public DoctorAppointmentRepository getDoctorAppointmentRepository() {
        return doctorAppointmentRepository;
    }

    public void setDoctorAppointmentRepository(DoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }

    public DoctorAppointment createDoctorAppointment(CreateAppointmentDTO createAppointmentDTO) {
        DoctorAppointment doctorAppointment = new DoctorAppointment();
        doctorAppointment.setPatientID(createAppointmentDTO.getPatientID());
        doctorAppointment.setDate(createAppointmentDTO.getDate());
        doctorAppointmentRepository.save(doctorAppointment);
        return doctorAppointment;
    }
}
