package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/test")
public class TestController {
    //Fields
    private TestService testService;

    //Constructor
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/getAll")
    public List<Test> getAllTests(){
        return testService.getAllTests();
    }

    @PostMapping("/create/{patientID}")
    public Test createTest(@PathVariable int patientID){
        return testService.createTest(patientID);
    }

    @PutMapping("/announceResult/{testID}")
    public Test announceResult(@PathVariable int testID, @RequestParam boolean result){
        return testService.announceResult(testID,result);
    }
    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}