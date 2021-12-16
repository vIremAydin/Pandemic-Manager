package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Attendance {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int attendanceID;

    @ElementCollection
    @CollectionTable(name = "active_students_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "student_id")
    private List<Integer> activeStudents;

    private String date;
    private String attendanceCode;

    //Default Constructor
    public Attendance(){

    }

    //Constructor
    public Attendance(List<Integer> activeStudents, String date, String attendanceCode) {
        this.activeStudents = activeStudents;
        this.date = date;
        this.attendanceCode = attendanceCode;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public List<Integer> getActiveStudents() {
        return activeStudents;
    }

    public void setActiveStudents(List<Integer> activeStudents) {
        this.activeStudents = activeStudents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }
}
