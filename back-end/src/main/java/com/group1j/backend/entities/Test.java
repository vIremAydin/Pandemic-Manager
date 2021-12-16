package com.group1j.backend.entities;

import javax.persistence.*;

@Entity
public class Test {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int testID;

    private int patientID;
    private boolean isPositive;
    private boolean isResultAnnounced;
    private String date;

    //Default Constructor
    public Test(){

    }

    //Constructor
    public Test(int patientID, boolean isPositive, boolean isResultAnnounced, String date) {
        this.patientID = patientID;
        this.isPositive = isPositive;
        this.isResultAnnounced = isResultAnnounced;
        this.date = date;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public boolean isResultAnnounced() {
        return isResultAnnounced;
    }

    public void setResultAnnounced(boolean resultAnnounced) {
        isResultAnnounced = resultAnnounced;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
