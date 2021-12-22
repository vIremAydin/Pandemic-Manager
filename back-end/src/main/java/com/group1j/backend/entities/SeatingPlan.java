package com.group1j.backend.entities;

import javax.persistence.*;

@Entity
public class SeatingPlan {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int seatingPlanID;

    private String plan; //It will be converted to multi dimensional list of student id's.

    //Default Constructor
    public SeatingPlan(){

    }

    //Constructor
    public SeatingPlan(String plan) {
        this.plan = plan;
    }

    public int getSeatingPlanID() {
        return seatingPlanID;
    }

    public void setSeatingPlanID(int seatingPlanID) {
        this.seatingPlanID = seatingPlanID;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
