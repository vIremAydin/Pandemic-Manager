package com.group1j.backend.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class DoctorAppointment extends Appointment {
    //Fields
    @OneToOne(fetch = FetchType.LAZY)
    private Doctor relatedDoctor;

    //Constructor


    public DoctorAppointment(int patientID, String date, boolean isApproved, Doctor relatedDoctor) {
        super(patientID, date, isApproved);
        this.relatedDoctor = relatedDoctor;
    }

    //Default Constructor
    public DoctorAppointment() {

    }

    public Doctor getRelatedDoctor() {
        return relatedDoctor;
    }

    public void setRelatedDoctor(Doctor relatedDoctor) {
        this.relatedDoctor = relatedDoctor;
    }
}
