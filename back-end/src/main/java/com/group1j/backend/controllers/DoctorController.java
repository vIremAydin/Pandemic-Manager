package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
    //Fields
    private DoctorService doctorService;

    //Constructor
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PutMapping("/approve/doctorAppointment/{doctorID}/{appointmentID}")
    public DoctorAppointment approveDoctorAppointment(@PathVariable int doctorID, @PathVariable int appointmentID){
        return doctorService.approveDoctorAppointment(doctorID, appointmentID);
    }

    @PostMapping("/create")
    public Doctor create(@RequestBody CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return doctorService.create(createUserDTO);
    }

    @GetMapping("/login/{id}/{password}")
    public boolean loginDoctor(@PathVariable int id, @PathVariable String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return doctorService.loginDoctor(id,password);
    }


    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
