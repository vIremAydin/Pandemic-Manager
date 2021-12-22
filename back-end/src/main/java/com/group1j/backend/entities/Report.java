package com.group1j.backend.entities;

import javax.persistence.*;

@MappedSuperclass
public class Report{
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int reportID;
    private String text;
    private String date;

    //Default Constructor
    public Report(){

    }

    //Constructor
    public Report(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
