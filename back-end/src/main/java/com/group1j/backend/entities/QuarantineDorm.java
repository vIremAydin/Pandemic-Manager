package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuarantineDorm {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int quarantineDormID;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Student> students;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Nurse> nursess;

    //Default Construtor
    public QuarantineDorm(){

    }

    //Constructor
    public QuarantineDorm(List<Student> students, List<Nurse> nursess) {
        this.students = students;
        this.nursess = nursess;
    }

    public int getQuarantineDormID() {
        return quarantineDormID;
    }

    public void setQuarantineDormID(int quarantineDormID) {
        this.quarantineDormID = quarantineDormID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Nurse> getNursess() {
        return nursess;
    }

    public void setNursess(List<Nurse> nursess) {
        this.nursess = nursess;
    }
}
