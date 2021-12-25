package com.group1j.backend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Instructor extends User{
    //Fields
    @OneToMany(mappedBy="instructor")
    private List<Course> courses;

    //Constructor
    public Instructor(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule, List<Course> courses) {
        super(id, name, email, password, covidStaus, vaccinationStatus, testRecord, schedule);
        this.courses = courses;
    }

    //Default Constructor
    public Instructor() {

    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
