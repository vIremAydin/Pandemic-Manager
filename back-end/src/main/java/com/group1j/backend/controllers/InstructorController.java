package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/instructor")
public class InstructorController {
    //Fields
    private InstructorService instructorService;

    //Constructor
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @PostMapping("/create")
    public Instructor createInstructor(@RequestBody CreateUserDTO createUserDTO){
        return instructorService.createInstructor(createUserDTO);
    }

    @GetMapping("/login")
    public boolean loginInstructor(@RequestBody UserLoginDTO userLoginDTO){
        return instructorService.loginInstructor(userLoginDTO);
    }

    @PutMapping("/update/TestNeededStatus/{id}")
    public Instructor updateTestNeededStatus(@PathVariable int id){
        return instructorService.updateTestNeededStatus(id);
    }

    @PutMapping("/update/InfectedStatus/{id}")
    public Instructor updateInfectedStatus(@PathVariable int id){
        return instructorService.updateInfectedStatus(id);
    }

    public InstructorService getInstructorService() {
        return instructorService;
    }

    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
}