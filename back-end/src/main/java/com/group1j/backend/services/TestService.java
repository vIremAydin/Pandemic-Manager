package com.group1j.backend.services;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private TestRepository testRepository;
    private StudentRepository studentRepository;

    //Constructor
    public TestService(TestRepository testRepository, StudentRepository studentRepository) {
        this.testRepository = testRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    /**
     * Method to find test according to id
     * @param id
     * @return
     */
    public Optional<Test> findByTestid(Integer id){
        return testRepository.findByTestID(id);
    }

    public TestRepository getTestRepository() {
        return testRepository;
    }

    public void setTestRepository(TestRepository appointmentRepository) {
        this.testRepository = testRepository;
    }

    /**
     * Method to create test
     * @param patientID
     * @return
     */
    public Test createTest(int patientID) {
        Optional<Student> student = studentRepository.findById(patientID);
        if(student.isPresent()){
            Test test = new Test();
            test.setPatientID(patientID);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            test.setDate(formatter.format(date));
            testRepository.save(test);

            Student s = student.get();
            s.getTestRecord().getPreviousTests().add(test);
            studentRepository.save(s);

            return test;
        }

        return null;
    }

    /**
     * Method to update test results
     * @param testID
     * @param result
     * @return
     */
    public Test announceResult(int testID, boolean result) {
        Optional<Test> test = testRepository.findByTestID(testID);
        if(test.isPresent()){
            Test t = test.get();
            t.setResultAnnounced(true);
            t.setPositive(result);
            testRepository.save(t);
            return t;
        }
        return null;
    }
}
