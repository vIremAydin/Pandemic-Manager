package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Attendance {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int attendanceID;

    @ElementCollection
    @CollectionTable(name = "active_students_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "student_id")
    private List<Integer> activeStudents;

    private String date;
    private String attendanceCode;
}
