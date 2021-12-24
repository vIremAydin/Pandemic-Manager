package com.group1j.backend.services;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    private DoctorAppointmentRepository doctorAppointmentRepository;
    private ScheduleRepository scheduleRepository;

    //Constructor
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor createDoctor(CreateUserDTO createUserDTO){
        return null;
    } //TODO

    public Optional<Doctor> findByDoctorid(Integer id){
        return doctorRepository.findById(id);
    }

    public DoctorRepository getDoctorRepository() {
        return doctorRepository;
    }

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public boolean loginDoctor(UserLoginDTO userLoginDTO) {
        Optional<Doctor> doctor = findByDoctorid(userLoginDTO.getId());
        if (doctor.isPresent()) {
            Doctor d = doctor.get();
            return d.getPassword().equals(userLoginDTO.getPassword());
        }
        return false;
    }

    public Doctor updateSchedule(int doctorID, int scheduleID) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorID);
        if(doctor.isPresent()){
            Doctor d = doctor.get();
            Schedule schedule = new Schedule();
            schedule.setScheduleID(scheduleID);

            d.setSchedule(schedule);

            doctorRepository.save(d);
            return d;
        }
        return null;

    }


}
