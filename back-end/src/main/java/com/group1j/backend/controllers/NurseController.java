package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.NurseService;
import org.springframework.web.bind.annotation.*;

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

    /**
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<Nurse> getAllNurses(){
        return nurseService.getAllNurses();
    }

    @PostMapping("/create")
    public Nurse createNurse(@RequestBody CreateUserDTO createUserDTO){
        return nurseService.createNurse(createUserDTO);
    }

    @GetMapping("/login")
    public boolean loginNurse(@RequestBody UserLoginDTO userLoginDTO){
        return NurseService.loginNurse(userLoginDTO);
    }

    @PutMapping("/update/TestNeededStatus/{id}")
    public Nurse updateTestNeededStatus(@PathVariable int id){
        return nurseService.updateTestNeededStatus(id);
    }

    @PutMapping("/update/InfectedStatus/{id}")
    public Nurse updateInfectedStatus(@PathVariable int id){
        return nurseService.updateInfectedStatus(id);
    }

    public NurseService getNurseService() {
        return nurseService;
    }

    public void setNurseService(NurseService nurseService) {
        this.nurseService = nurseService;
    }
}
