package com.group1j.backend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.File;
import java.util.List;

@Entity
public class Instructor extends User{
    //Fields
    @OneToMany(mappedBy="instructor")
    private List<Course> courses;

    private File lectureNote;
    //Constructor
    public Instructor(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule, List<Course> courses, File lectureNote) {
        super(id, name, email, password, covidStaus, vaccinationStatus, testRecord, schedule);
        this.courses = courses;
        this.lectureNote = lectureNote;
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
    public File getLectureNote() {
        return lectureNote;
    }

    public void addLectureNotes() {
        this.lectureNote = lectureNote;
    }
}
