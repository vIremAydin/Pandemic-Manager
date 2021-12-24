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

    public boolean loginDoctor(int id, String password) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()){
            Doctor d = doctor.get();
            return d.getPassword().equals(password);
        }
        return false;
    }


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
