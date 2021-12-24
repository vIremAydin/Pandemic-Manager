package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestRecord {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int testRecordID;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Test> previousTests;

    //Default Constructor
    public TestRecord(){
        previousTests = new ArrayList<>();
    }

    public int getTestRecordID() {
        return testRecordID;
    }

    public void setTestRecordID(int testRecordID) {
        this.testRecordID = testRecordID;
    }

    public List<Test> getPreviousTests() {
        return previousTests;
    }

    public void setPreviousTests(List<Test> previousTests) {
        this.previousTests = previousTests;
    }
}
