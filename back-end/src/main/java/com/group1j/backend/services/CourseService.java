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
public class CourseService {

    private CourseRepository courseRepository;

    //Constructor
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    //public Course createCourse(CreateUserDTO createUserDTO){} //TODO

    public Optional<Course> findByCourseid(Integer id){
        return courseRepository.findByCourseId(id);
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
