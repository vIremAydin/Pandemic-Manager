package com.group1j.backend.entities;

import javax.persistence.Entity;

@Entity
public class HealthReport extends Report{
    //Fields
    private int healthPersonalID;

    //Default Constructor
    public HealthReport() {
    }

    //Constructor
    public HealthReport(String text, String date, int healthPersonalID) {
        super(text, date);
        this.healthPersonalID = healthPersonalID;
    }

    public int getHealthPersonalID() {
        return healthPersonalID;
    }

    public void setHealthPersonalID(int healthPersonalID) {
        this.healthPersonalID = healthPersonalID;
    }
}
