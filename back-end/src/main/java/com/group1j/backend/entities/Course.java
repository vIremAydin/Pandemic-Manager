package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int courseID;

    private String courseName;
    private int section;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Student> enrolledStudents;

    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attendance> attendanceRecord;

    @OneToOne(fetch = FetchType.LAZY)
    private SeatingPlan seatingPlan;

    //Default Constructor
    public Course(){

    }

    //Constructor
    public Course(String courseName, List<Student> enrolledStudents, Instructor instructor, List<Attendance> attendanceRecord, SeatingPlan seatingPlan) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
        this.instructor = instructor;
        this.attendanceRecord = attendanceRecord;
        this.seatingPlan = seatingPlan;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Attendance> getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(List<Attendance> attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }

    public void setSeatingPlan(SeatingPlan seatingPlan) {
        this.seatingPlan = seatingPlan;
    }
}
