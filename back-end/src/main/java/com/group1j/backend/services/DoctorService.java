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
public class DoctorService {
    private DoctorRepository doctorRepository;
    private DoctorAppointmentRepository doctorAppointmentRepository;
    private StudentRepository studentRepository;

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
        //TODO
        //Optional<Student> student = findByStudentid(userLoginDTO.getId());
        //if (student.isPresent()){
        //    Student s = student.get();
        //    return s.getPassword().equals(userLoginDTO.getPassword());
        //}
        return false;
    }


}
