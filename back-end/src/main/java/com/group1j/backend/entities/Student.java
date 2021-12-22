package com.group1j.backend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student extends User {
    //Fields
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Course> enrolledCourses;

    private int startYear;

    //Constructor
    public Student(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule, List<Course> enrolledCourses, int startYear) {
        super(id, name, email, password, covidStaus, vaccinationStatus, testRecord, schedule);
        this.enrolledCourses = enrolledCourses;
        this.startYear = startYear;
    }

    //Default Constructor
    public Student() {

    }
}
