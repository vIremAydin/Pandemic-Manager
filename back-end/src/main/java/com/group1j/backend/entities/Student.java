package com.group1j.backend.entities;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Student extends User {
    //Fields
    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Course> enrolledCourses;

    @ManyToOne
    private Instructor instructor;

    private File lectureNote;
    private int startYear;

    //Constructor
    public Student(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule, List<Course> enrolledCourses, int startYear, File lectureNote) {
        super(id, name, email, password, covidStaus, vaccinationStatus, testRecord, schedule);
        this.enrolledCourses = enrolledCourses;
        this.startYear = startYear;
        this.lectureNote = getLectureNote();
    }

    //Default Constructor
    public Student() {

    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public File getLectureNote() {
        return instructor.getLectureNote();
    }

}
