package com.group1j.backend.services;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService extends UserService {
    private StudentRepository studentRepository;

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

    public Student createStudent(CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Student> students = studentRepository.findById(createUserDTO.getId());
        if(students.isPresent()){
            throw new RuntimeException("Student already exists");
        }

        CovidStatus covidStatus = new CovidStatus(false,false,false,false,"",true,createUserDTO.getHesCode());
        VaccinationStatus vaccinationStatus = new VaccinationStatus();
        Schedule schedule = new Schedule();
        TestRecord testRecord = new TestRecord();
        Student student = new Student(createUserDTO.getId(),createUserDTO.getName(),createUserDTO.getEmail(),createUserDTO.getPassword(),covidStatus,vaccinationStatus,testRecord,schedule,new ArrayList<>(),2020);
        student.setPassword(encode(student.getPassword(),student.getPasswordNum()));
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

    public boolean loginStudent(int id, String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            Student s = student.get();
            return decode(s.getPassword(),s.getPasswordNum()).equals(password);
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

    public Student updateContactedStatus(int id) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().setContacted(!s.getCovidStaus().isContacted());
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student updatePreviouslyInfectedStatus(int id) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().setPreviouslyInfected(!s.getCovidStaus().isPreviouslyInfected());
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student updateAllowedStatus(int id) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().setAllowedToCampus(!s.getCovidStaus().isAllowedToCampus());
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student updateTestDeadline(int id, String testDeadline) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().setTestDeadline(testDeadline);
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student addSymptom(int id, String symptom) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getCovidStaus().getSymptoms().add(symptom);
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student addVaccinationName(int id, String vaccination) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getVaccinationStatus().getVaccinationNames().add(vaccination);
            s.getVaccinationStatus().setNumOfDoses(s.getVaccinationStatus().getVaccinationNames().size());
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public Student addVaccinationDate(int id, String date) {
        Optional<Student> student = findByStudentid(id);
        if (student.isPresent()){
            Student s = student.get();
            s.getVaccinationStatus().getDatesOfDoses().add(date);
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    public List<Student> getNotAllowedOnes() {
        List<Student> notAllowed = new ArrayList<>();
        List<Student> all = studentRepository.findAll();

        for(int i = 0; i < all.size(); i++){
            if(!all.get(i).getCovidStaus().isAllowedToCampus()){
                notAllowed.add(all.get(i));
            }
        }

        return notAllowed;
    }
}
