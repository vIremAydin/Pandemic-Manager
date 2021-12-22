package com.group1j.backend.entities;

import javax.persistence.Entity;

@Entity
public class BanReport extends Report{
    //Fields
    private int senderID;

    //Default Constructor
    public BanReport(){
        super();
    }

    //Constructor
    public BanReport(String text, String date, int senderID) {
        super(text, date);
        this.senderID = senderID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }
}
