package com.group1j.backend.entities;

import javax.persistence.*;

@Entity
public class TestRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int testRecordID;
}
