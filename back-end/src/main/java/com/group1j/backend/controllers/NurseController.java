package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.NurseService;
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
@RequestMapping("api/nurse")
public class NurseController {
    //Fields
    private NurseService nurseService;

    //Constructor
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping("/getAll")
    public List<Nurse> getAllNurses(){
        return nurseService.getAllNurses();
    }

    @PostMapping("/create")
    public Nurse createNurse(@RequestBody CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return nurseService.create(createUserDTO);
    }

    @GetMapping("/login/{id}/{password}")
    public boolean loginNurse(@PathVariable int id, @PathVariable String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return nurseService.loginNurse(id,password);
    }
    @PutMapping("/approve/testAppointment/{nurseID}/{appointmentID}")
    public TestAppointment approveTestAppointment(@PathVariable int nurseID, @PathVariable int appointmentID){
        return nurseService.approveTestAppointment(nurseID,appointmentID);
    }

    public NurseService getNurseService() {
        return nurseService;
    }

    public void setNurseService(NurseService nurseService) {
        this.nurseService = nurseService;
    }
}
