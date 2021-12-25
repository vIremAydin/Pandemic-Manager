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
public class NurseService extends UserService implements CreateTemplate{
    private NurseRepository nurseRepository;
    private TestAppointmentRepository testAppointmentRepository;
    private StudentRepository studentRepository;

    //Constructor


    public NurseService(NurseRepository nurseRepository, TestAppointmentRepository testAppointmentRepository, StudentRepository studentRepository) {
        this.nurseRepository = nurseRepository;
        this.testAppointmentRepository = testAppointmentRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Nurse> getAllNurses(){
        return nurseRepository.findAll();
    }



    public Optional<Nurse> findByNurseid(Integer id){
        return nurseRepository.findById(id);
    }

    public NurseRepository getNurseRepository() {
        return nurseRepository;
    }

    public void setNurseRepository(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public boolean loginNurse(int id, String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Nurse> nurse = nurseRepository.findById(id);
        if (nurse.isPresent()){
            Nurse n = nurse.get();
            return decode(n.getPassword(),n.getPasswordNum()).equals(password);
        }
        return false;
    }

    @Override
    public Nurse create(CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Nurse> nurses = nurseRepository.findById(createUserDTO.getId());
        if(nurses.isPresent()){
            throw new RuntimeException("Nurse already exists");
        }

        CovidStatus covidStatus = new CovidStatus(false,false,false,false,"",true,createUserDTO.getHesCode());
        VaccinationStatus vaccinationStatus = new VaccinationStatus();
        Schedule schedule = new Schedule();
        TestRecord testRecord = new TestRecord();

        Nurse nurse = new Nurse(createUserDTO.getId(),createUserDTO.getName(),createUserDTO.getEmail(),createUserDTO.getPassword(),covidStatus,vaccinationStatus,testRecord,schedule);
        nurse.setPassword(encode(nurse.getPassword(),nurse.getPasswordNum()));
        nurseRepository.save(nurse);
        return nurse;
    }

    public TestAppointment approveTestAppointment(int nurseID, int appointmentID) {
        Optional<Nurse> nurse = nurseRepository.findById(nurseID);
        Optional<TestAppointment> testAppointment = testAppointmentRepository.findByAppointmentID(appointmentID);

        if(nurse.isPresent() && testAppointment.isPresent()){
            Nurse n = nurse.get();
            TestAppointment t = testAppointment.get();

            t.setApproved(true);
            t.setRelatedNurse(n);
            n.getSchedule().getTestAppointments().add(t);

            Optional<Student> student = studentRepository.findById(t.getPatientID());
            if(student.isPresent()){
                Student s = student.get();
                s.getSchedule().getTestAppointments().add(t);
                studentRepository.save(s);
            }

            nurseRepository.save(n);
            testAppointmentRepository.save(t);
            return t;

        }
        return null;
    }
}
