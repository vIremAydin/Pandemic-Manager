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
import java.util.Random;

@Service
public class StudentService extends UserService implements CreateTemplate{
    //Fields
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

    /**
     * Method to create student account
     * @param createUserDTO
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    @Override
    public Student create(CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Student> students = studentRepository.findById(createUserDTO.getId());
        if(students.isPresent()){
            throw new RuntimeException("Student already exists");
        }

        CovidStatus covidStatus = new CovidStatus();
        Random rand = new Random();
        int boolIndicator1 = rand.nextInt() % 2;
        int boolIndicator2 = rand.nextInt() % 2;
        int boolIndicator3 = rand.nextInt() % 2;

        if(boolIndicator1 == 1){
            covidStatus.setInfected(true);
            covidStatus.setAllowedToCampus(false);
        }

        else{
            covidStatus.setInfected(false);
            covidStatus.setAllowedToCampus(true);
        }

        if(boolIndicator2 == 1){
            covidStatus.setContacted(true);
        }

        else{
            covidStatus.setContacted(false);
        }

        if(boolIndicator3 == 1){
            covidStatus.setPreviouslyInfected(true);
        }

        else{
            covidStatus.setPreviouslyInfected(false);
        }

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

    /**
     * Method for login purpose
     * @param id
     * @param password
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public boolean loginStudent(int id, String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            Student s = student.get();
            return decode(s.getPassword(),s.getPasswordNum()).equals(password);
        }
        return false;
    }

    /**
     * It updates the status for needing test
     * @param id
     * @return
     */
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

    /**
     * It updates the infection status of the student
     * @param id
     * @return
     */
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

    /**
     * It updates the contacted status
     * @param id
     * @return
     */
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

    /**
     * It updates whether student is previously infected or not
     * @param id
     * @return
     */
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

    /**
     * It updates whether student is allowed to campus or not
     * @param id
     * @return
     */
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

    /**
     * It updates the test deadline of the user
     * @param id
     * @param testDeadline
     * @return
     */
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

    /**
     * It adds symptom according to user's circumstance
     * @param id
     * @param symptom
     * @return
     */
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

    /**
     * It adds vaccination names
     * @param id
     * @param vaccination
     * @return
     */
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

    /**
     * This method adds vaccination dates
     * @param id
     * @param date
     * @return
     */
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

    /**
     * This function returns all of the students that are not allowed to be in campus
     * @return
     */
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
