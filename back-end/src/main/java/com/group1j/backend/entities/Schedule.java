package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Schedule {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int scheduleID;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DoctorAppointment> doctorAppointments;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TestAppointment> testAppointments;

    //Default Constructor
    public Schedule(){

    }

    //Constructor
    public Schedule(List<DoctorAppointment> doctorAppointments, List<TestAppointment> testAppointments) {
        this.doctorAppointments = doctorAppointments;
        this.testAppointments = testAppointments;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public List<DoctorAppointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(List<DoctorAppointment> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }

    public List<TestAppointment> getTestAppointments() {
        return testAppointments;
    }

    public void setTestAppointments(List<TestAppointment> testAppointments) {
        this.testAppointments = testAppointments;
    }
}
