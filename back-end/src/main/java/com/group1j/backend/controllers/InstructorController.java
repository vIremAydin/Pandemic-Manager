package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.InstructorService;
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
    public Instructor create(@RequestBody CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return instructorService.create(createUserDTO);
    }

    @GetMapping("/login/{id}/{password}")
    public boolean loginInstructor(@PathVariable int id, @PathVariable String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return instructorService.loginInstructor(id,password);
    }

    @PostMapping("/add/course/{instructorID}/{courseID}")
    public Instructor addCourse(@PathVariable int instructorID, @PathVariable int courseID){
        return instructorService.addCourse(instructorID,courseID);
    }



    public InstructorService getInstructorService() {
        return instructorService;
    }

    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
}