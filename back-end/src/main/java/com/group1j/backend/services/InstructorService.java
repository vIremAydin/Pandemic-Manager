package com.group1j.backend.services;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    private InstructorRepository instructorRepository;
    private CourseRepository courseRepository;

    //Constructor


    public InstructorService(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    /**
     * Method for returning all of the instructors in the system
     * @return
     */
    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Instructor createInstructor(CreateUserDTO createUserDTO){
        Optional<Instructor> instructors = instructorRepository.findById(createUserDTO.getId());
        if(instructors.isPresent()){
            throw new RuntimeException("Instructor already exists");
        }

        CovidStatus covidStatus = new CovidStatus(false,false,false,false,"",true,createUserDTO.getHesCode());
        VaccinationStatus vaccinationStatus = new VaccinationStatus();
        Schedule schedule = new Schedule();
        TestRecord testRecord = new TestRecord();

        Instructor instructor = new Instructor(createUserDTO.getId(),createUserDTO.getName(),createUserDTO.getEmail(),createUserDTO.getPassword(),covidStatus,vaccinationStatus,testRecord,schedule,new ArrayList<>());
        instructorRepository.save(instructor);
        return instructor;
    }

    public Optional<Instructor> findByInstructorid(Integer id){
        return instructorRepository.findById(id);
    }

    public InstructorRepository getInstructorRepository() {
        return instructorRepository;
    }

    public void setInstructorRepository(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public boolean loginInstructor(UserLoginDTO userLoginDTO) {
        Optional<Instructor> instructor = findByInstructorid(userLoginDTO.getId());
        if (instructor.isPresent()){
            Instructor instructor1 = instructor.get();
            return instructor1.getPassword().equals(userLoginDTO.getPassword());
        }
        return false;
    }


    public Instructor addCourse(int instructorID, int courseID) {
        Optional<Instructor> instructor = instructorRepository.findById(instructorID);
        Optional<Course> course = courseRepository.findByCourseID(courseID);

        if(instructor.isPresent() && course.isPresent()){
            Instructor i = instructor.get();
            Course c = course.get();

            c.setInstructor(i);
            courseRepository.save(c);
            return i;
        }

        return null;
    }
}