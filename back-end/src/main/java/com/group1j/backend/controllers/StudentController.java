package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.StudentService;
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

    @GetMapping("/get/NotAllowedOnes")
    public List<Student> getNotAllowedOnes(){
        return studentService.getNotAllowedOnes();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody CreateUserDTO createUserDTO) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return studentService.create(createUserDTO);
    }

    @GetMapping("/login/{id}/{password}")
    public boolean loginStudent(@PathVariable int id, @PathVariable String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return studentService.loginStudent(id,password);
    }

    @PutMapping("/update/TestNeededStatus/{id}")
    public Student updateTestNeededStatus(@PathVariable int id){
        return studentService.updateTestNeededStatus(id);
    }

    @PutMapping("/update/InfectedStatus/{id}")
    public Student updateInfectedStatus(@PathVariable int id){
        return studentService.updateInfectedStatus(id);
    }

    @PutMapping("/update/ContactedStatus/{id}")
    public Student updateContactedStatus(@PathVariable int id){
        return studentService.updateContactedStatus(id);
    }

    @PutMapping("/update/PreviouslyInfectedStatus/{id}")
    public Student updatePreviouslyInfectedStatus(@PathVariable int id){
        return studentService.updatePreviouslyInfectedStatus(id);
    }

    @PutMapping("/update/AllowedStatus/{id}")
    public Student updateAllowedStatus(@PathVariable int id){
        return studentService.updateAllowedStatus(id);
    }

    @PutMapping("/update/TestDeadline/{id}")
    public Student updateTestDeadline(@PathVariable int id, @RequestBody String testDeadline){
        return studentService.updateTestDeadline(id,testDeadline);
    }

    @PostMapping("/add/symptom/{id}")
    public Student addSymptom(@PathVariable int id, @RequestBody String symptom){
        return studentService.addSymptom(id,symptom);
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.findByStudentid(id).get();
    }

    @PostMapping("/add/vaccinationName/{id}")
    public Student addVaccinationName(@PathVariable int id, @RequestBody String vaccination){
        return studentService.addVaccinationName(id,vaccination);
    }

    @PostMapping("/add/vaccinationDate/{id}")
    public Student addVaccinationDate(@PathVariable int id, @RequestBody String date){
        return studentService.addVaccinationDate(id,date);
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
