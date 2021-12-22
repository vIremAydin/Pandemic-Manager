package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/student")
public class StudentController {
    //Fields
    private StudentService studentService;

    //Constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody CreateUserDTO createUserDTO){
        return studentService.createStudent(createUserDTO);
    }

    @GetMapping("/login")
    public boolean loginStudent(@RequestBody UserLoginDTO userLoginDTO){
        return studentService.loginStudent(userLoginDTO);
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
