package com.group1j.backend.services;

import com.group1j.backend.dto.CreateCourseDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.repositories.*;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * Method to add student to the course
     * @param courseID
     * @param studentID
     * @return
     */
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

    /**
     * Method to create course
     * @param createCourseDTO
     * @return
     */
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

    /**
     * Method to create Attendance object
     * @param courseID
     * @return
     */
    public Course createAttendance(int courseID) {
        Optional<Course> course = courseRepository.findByCourseID(courseID);
        if(course.isPresent()){
            Course c = course.get();
            Attendance attendance = new Attendance();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            attendance.setDate(formatter.format(date));
            attendance.setAttendanceCode(UUID.randomUUID().toString());
            c.getAttendanceRecord().add(attendance);
            courseRepository.save(c);
            return c;
        }
        return null;

    }

    /**
     * This method adds seating plan to a course
     * @param courseID
     * @param seatingPlan
     * @return
     */
    public Course addSeatingPlan(int courseID, List<List<Integer>> seatingPlan) {
        Optional<Course> course = courseRepository.findByCourseID(courseID);
        if(course.isPresent()){
            String elPlan = convertPlanToString(seatingPlan);
            Course c = course.get();
            SeatingPlan plan = new SeatingPlan(elPlan);
            c.setSeatingPlan(plan);
            courseRepository.save(c);
            return c;
        }

        return null;
    }

    /**
     * This method converts multi dimensional list to string in order to store it in database
     * id,id,id;id,id,id,id;id,id -> , represents different columns in a row ; represents that row is changed
     * @param seatingPlan
     * @return
     */
    public String convertPlanToString(List<List<Integer>> seatingPlan){
        String elPlan = "";

        for(int i = 0; i < seatingPlan.size(); i++){
            for(int j = 0; j < seatingPlan.get(i).size(); j++){
                elPlan = elPlan + seatingPlan.get(i).get(j);
                if(j != seatingPlan.get(i).size() - 1)
                    elPlan = elPlan + ",";
            }
            elPlan = elPlan + ";";
        }

        return elPlan;
    }

    /**
     * This method converts string to List<List<Integer>>
     * @param elPlan
     * @return
     */
    public List<List<Integer>> convertPlanToList(String elPlan){
        int index = 0;
        int indexComma = 0; //Initial
        int indexSemicolon = 0; //Initial
        int row = 0;

        List<List<Integer>> seatingPlan = new ArrayList<>();
        seatingPlan.add(new ArrayList<>()); //First row has been added

        while(index < elPlan.length()-1 || indexComma != -1 || indexSemicolon != -1){
            indexComma = elPlan.indexOf(",",index);
            indexSemicolon = elPlan.indexOf(";",index);

            if(indexComma != -1 && indexComma < indexSemicolon){
                int number = Integer.parseInt(elPlan.substring(index,indexComma));
                seatingPlan.get(row).add(number);
                index = indexComma + 1;
            }

            else if(indexSemicolon < indexComma){
                int number = Integer.parseInt(elPlan.substring(index,indexSemicolon));
                seatingPlan.get(row).add(number);
                seatingPlan.add(new ArrayList<>()); //New row will start
                row = row + 1;
                index = indexSemicolon + 1;
            }

            else if(indexComma == -1 && indexSemicolon != -1 ){
                int number = Integer.parseInt(elPlan.substring(index,indexSemicolon));
                seatingPlan.get(row).add(number);
                index = indexSemicolon + 1;
            }

            else{
                break;
            }
        }

        return seatingPlan;
    }

    public List<List<Integer>> getSeatingPlan(int courseID) {
        Optional<Course> course = courseRepository.findByCourseID(courseID);
        if(course.isPresent()){
            Course c = course.get();
            return convertPlanToList(c.getSeatingPlan().getPlan());
        }

        return null;
    }
}
