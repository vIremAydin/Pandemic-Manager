package com.group1j.backend.entities;

import javax.persistence.Entity;

@Entity
public class Nurse extends User {

    //Constructor
    public Nurse(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule) {
        super(id, name, email, password, covidStaus, vaccinationStatus, testRecord, schedule);
    }

    //Default Constructor
    public Nurse() {

    }
}
