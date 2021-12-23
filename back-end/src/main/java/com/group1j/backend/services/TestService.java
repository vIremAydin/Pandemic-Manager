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
public class TestService {

    private TestRepository testRepository;

    //Constructor
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    //public Appointment createAppointment(CreateUserDTO createUserDTO){} //TODO

    public Optional<Test> findByTestid(Integer id){
        return testRepository.findByTestID(id);
    }

    public TestRepository getTestRepository() {
        return testRepository;
    }

    public void setTestRepository(TestRepository appointmentRepository) {
        this.testRepository = testRepository;
    }

}
