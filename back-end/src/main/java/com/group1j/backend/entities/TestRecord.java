package com.group1j.backend.entities;

import javax.persistence.*;
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
}
