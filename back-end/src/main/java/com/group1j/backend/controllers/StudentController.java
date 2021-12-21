package com.group1j.backend.controllers;

import com.group1j.backend.entities.Student;
import com.group1j.backend.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
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
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
