package com.group1j.backend.repositories;

import com.group1j.backend.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    //inherited
    //@Query("SELECT x FROM Appointment x WHERE x.appointmentID = ?1")
    Optional<Appointment> findByAppointmentId(Integer appointmentID);


    //@Query("SELECT x FROM Appointment x WHERE x.patientID = ?1")
    Optional<Appointment> findByPatientID(Integer patientID);
}
