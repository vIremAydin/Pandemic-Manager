package com.group1j.backend.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    //Fields
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    private CovidStatus covidStaus;
    private VaccinationStatus vaccinationStatus;
    private TestRecord testRecord;
    private Schedule schedule;

    public User(int id, String name, String email, String password, CovidStatus covidStaus, VaccinationStatus vaccinationStatus, TestRecord testRecord, Schedule schedule) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.covidStaus = covidStaus;
        this.vaccinationStatus = vaccinationStatus;
        this.testRecord = testRecord;
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CovidStatus getCovidStaus() {
        return covidStaus;
    }

    public void setCovidStaus(CovidStatus covidStaus) {
        this.covidStaus = covidStaus;
    }

    public VaccinationStatus getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(VaccinationStatus vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }

    public TestRecord getTestRecord() {
        return testRecord;
    }

    public void setTestRecord(TestRecord testRecord) {
        this.testRecord = testRecord;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
