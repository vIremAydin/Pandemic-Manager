package com.group1j.backend.entities;

import javax.persistence.Entity;

@Entity
public class Doctor extends User {
    //Fields
    private String speciality;

    //Constructor
    public Doctor(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule, String speciality) {
        super(id, name, email, password, covidStaus, vaccinationStatus, testRecord, schedule);
        this.speciality = speciality;
    }

    //Default Constructor
    public Doctor() {
        super();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
