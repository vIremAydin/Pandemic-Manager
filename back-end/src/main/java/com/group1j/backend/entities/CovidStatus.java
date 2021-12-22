package com.group1j.backend.entities;

import javax.persistence.*;

@Entity
public class CovidStatus {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int covidStatusID;
    private boolean isInfected;
    private boolean isContacted;
    private boolean previouslyInfected;
    private boolean isTestNeeded;
    private String testDeadline;
    private boolean isAllowedToCampus;
    private String hesCode;


    //Constructor
    public CovidStatus(boolean isInfected, boolean isContacted, boolean previouslyInfected, boolean isTestNeeded, String testDeadline, boolean isAllowedToCampus, String hesCode) {
        this.isInfected = isInfected;
        this.isContacted = isContacted;
        this.previouslyInfected = previouslyInfected;
        this.isTestNeeded = isTestNeeded;
        this.testDeadline = testDeadline;
        this.isAllowedToCampus = isAllowedToCampus;
        this.hesCode = hesCode;
    }
    //Default Constructor
    public CovidStatus() {

    }

    public boolean isInfected() {
        return isInfected;
    }

    public void setInfected(boolean infected) {
        isInfected = infected;
    }

    public boolean isContacted() {
        return isContacted;
    }

    public void setContacted(boolean contacted) {
        isContacted = contacted;
    }

    public boolean isPreviouslyInfected() {
        return previouslyInfected;
    }

    public void setPreviouslyInfected(boolean previouslyInfected) {
        this.previouslyInfected = previouslyInfected;
    }

    public boolean isTestNeeded() {
        return isTestNeeded;
    }

    public void setTestNeeded(boolean testNeeded) {
        isTestNeeded = testNeeded;
    }

    public String getTestDeadline() {
        return testDeadline;
    }

    public void setTestDeadline(String testDeadline) {
        this.testDeadline = testDeadline;
    }

    public boolean isAllowedToCampus() {
        return isAllowedToCampus;
    }

    public void setAllowedToCampus(boolean allowedToCampus) {
        isAllowedToCampus = allowedToCampus;
    }

    public String getHesCode() {
        return hesCode;
    }

    public void setHesCode(String hesCode) {
        this.hesCode = hesCode;
    }

    public int getCovidStatusID() {
        return covidStatusID;
    }

    public void setCovidStatusID(int covidStatusID) {
        this.covidStatusID = covidStatusID;
    }
}
