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
public class NurseService {
    private NurseRepository nurseRepository;

    //Constructor
    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Nurse> getAllNurses(){
        return nurseRepository.findAll();
    }

    //public Doctor createDoctor(CreateUserDTO createUserDTO){} //TODO

    public Optional<Nurse> findByNurseid(Integer id){
        return nurseRepository.findById(id);
    }

    public NurseRepository getNurseRepository() {
        return nurseRepository;
    }

    public void setNurseRepository(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public boolean loginNurse(UserLoginDTO userLoginDTO) {
        //TODO
        //Optional<Student> student = findByStudentid(userLoginDTO.getId());
        //if (student.isPresent()){
        //    Student s = student.get();
        //    return s.getPassword().equals(userLoginDTO.getPassword());
        //}
        //return false;
    }

    public Nurse updateTestNeededStatus(int id) {
        //TODO
        //Optional<Student> student = findByStudentid(id);
        //if (student.isPresent()){
        //    Student s = student.get();
        //    s.getCovidStaus().setTestNeeded(!s.getCovidStaus().isTestNeeded());
        //    studentRepository.save(s);
        //    return s;
        //}
        //return null;
    }

    public Nurse updateInfectedStatus(int id) {
        //TODO
        //Optional<Student> student = findByStudentid(id);
        //if (student.isPresent()){
        //    Student s = student.get();
        //    s.getCovidStaus().setInfected(!s.getCovidStaus().isInfected());
        //    studentRepository.save(s);
        //    return s;
        //}
        //return null;
    }
}
