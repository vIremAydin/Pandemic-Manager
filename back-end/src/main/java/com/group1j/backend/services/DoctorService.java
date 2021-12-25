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
import java.text.SimpleDateFormat;
import java.util.*;
@Service
public class DoctorService extends UserService implements CreateTemplate {
    private DoctorRepository doctorRepository;
    private DoctorAppointmentRepository doctorAppointmentRepository;
    private StudentRepository studentRepository;


    //Constructor
    public DoctorService(DoctorRepository doctorRepository, DoctorAppointmentRepository doctorAppointmentRepository, StudentRepository studentRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorAppointmentRepository = doctorAppointmentRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    /**
     * Method to create doctor account
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
    public Doctor create(CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Doctor> doctors = doctorRepository.findById(createUserDTO.getId());
        if(doctors.isPresent()){
            throw new RuntimeException("Doctor already exists");
        }

        CovidStatus covidStatus = new CovidStatus(false,false,false,false,"",true,createUserDTO.getHesCode());
        VaccinationStatus vaccinationStatus = new VaccinationStatus();
        Schedule schedule = new Schedule();
        TestRecord testRecord = new TestRecord();

        Doctor doctor = new Doctor(createUserDTO.getId(),createUserDTO.getName(),createUserDTO.getEmail(),createUserDTO.getPassword(),covidStatus,vaccinationStatus,testRecord,schedule,"");
        doctor.setPassword(encode(doctor.getPassword(),doctor.getPasswordNum()));
        doctorRepository.save(doctor);
        return doctor;
    } 

    public Optional<Doctor> findByDoctorid(Integer id){
        return doctorRepository.findById(id);
    }

    public DoctorRepository getDoctorRepository() {
        return doctorRepository;
    }

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Method for login purposes
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
    public boolean loginDoctor(int id, String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()){
            Doctor d = doctor.get();
            decode(d.getPassword(),d.getPasswordNum()).equals(password);
        }
        return false;
    }

    /**
     * Method for approving doctor appointments
     * @param doctorID
     * @param appointmentID
     * @return
     */
    public DoctorAppointment approveDoctorAppointment(int doctorID, int appointmentID) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorID);
        Optional<DoctorAppointment> doctorAppointment = doctorAppointmentRepository.findByAppointmentID(appointmentID);

        if(doctor.isPresent() && doctorAppointment.isPresent()){
            Doctor doc = doctor.get();
            DoctorAppointment appo = doctorAppointment.get();

            appo.setApproved(true);
            appo.setRelatedDoctor(doc);
            doc.getSchedule().getDoctorAppointments().add(appo);

            Optional<Student> student = studentRepository.findById(appo.getPatientID());
            if(student.isPresent()){
                Student s = student.get();
                s.getSchedule().getDoctorAppointments().add(appo);
                studentRepository.save(s);
            }

            doctorRepository.save(doc);
            doctorAppointmentRepository.save(appo);

            return appo;

        }

        return null;
    }
}
