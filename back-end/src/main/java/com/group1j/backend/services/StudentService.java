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
public class StudentService {
    private StudentRepository studentRepository;
    private CovidStatusRepository covidStatusRepository;
    private VaccinationStatusRepository vaccinationStatusRepository;
    private TestRecordRepository testRecordRepository;
    private ScheduleRepository scheduleRepository;


    //Constructor
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(CreateUserDTO createUserDTO){
        Optional<Student> students = studentRepository.findById(createUserDTO.getId());
        if(students.isPresent()){
            throw new RuntimeException("Student already exists");
        }

        CovidStatus covidStatus = new CovidStatus(false,false,false,false,"",true,createUserDTO.getHesCode());
        VaccinationStatus vaccinationStatus = new VaccinationStatus();
        Schedule schedule = new Schedule();
        TestRecord testRecord = new TestRecord();
//        vaccinationStatusRepository.save(vaccinationStatus);
//        scheduleRepository.save(schedule);
//        testRecordRepository.save(testRecord);
//        covidStatusRepository.save(covidStatus);
        Student student = new Student(createUserDTO.getId(),createUserDTO.getName(),createUserDTO.getEmail(),createUserDTO.getPassword(),covidStatus,vaccinationStatus,testRecord,schedule,new ArrayList<>(),2020);
        studentRepository.save(student);
        return student;
    }

    public Optional<Student> findByStudentid(Integer id){
        return studentRepository.findById(id);
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public boolean loginStudent(UserLoginDTO userLoginDTO) {
        Optional<Student> student = findByStudentid(userLoginDTO.getId());
        if (student.isPresent()){
            Student s = student.get();
            return s.getPassword().equals(userLoginDTO.getPassword());
        }
        return false;
    }

    public Student updateTestNeededStatus(int id) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().setTestNeeded(!s.getCovidStaus().isTestNeeded());
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student updateInfectedStatus(int id) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().setInfected(!s.getCovidStaus().isInfected());
            studentRepository.save(s);
            return s;
        }
        return null;
    }
}
