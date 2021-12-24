package com.group1j.backend.services;

import com.group1j.backend.dto.CreateCourseDTO;
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
    private StudentRepository studentRepository;

    //Constructor


    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Course addStudent(int courseID, int studentID) {
        Optional<Student> student = studentRepository.findById(studentID);
        Optional<Course> course = courseRepository.findByCourseID(courseID);
        if (course.isPresent() && student.isPresent()){
            Student s = student.get();
            Course c = course.get();

            c.getEnrolledStudents().add(s);

            courseRepository.save(c);
            return c;
        }
        return null;
    }

    public Course updateSeatingPlan(int seatingPlanID, int courseID) {
        Optional<Course> course = courseRepository.findByCourseID(courseID);
        if (course.isPresent()){
            Course c = course.get();
            c.getSeatingPlan().setSeatingPlanID(seatingPlanID);
            courseRepository.save(c);
            return c;
        }
        return null;
    }

    /**
     * Method for returning all of the students in the system
     * @return
     */
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> findByCourseid(Integer id){
        return courseRepository.findByCourseID(id);
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(CreateCourseDTO createCourseDTO) {
        Optional<Course> course = courseRepository.findByCourseNameAndSection(createCourseDTO.getCourseName(),createCourseDTO.getSection());
        if(course.isPresent()){
            throw new RuntimeException("Course already exists");
        }

        else{
            Course c = new Course();
            c.setCourseName(createCourseDTO.getCourseName());
            c.setSection(createCourseDTO.getSection());
            courseRepository.save(c);
            return c;
        }
    }
}
