package com.group1j.backend.repositories;

import com.group1j.backend.entities.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment,Integer> {

    //inherited patientID
    //@Query("SELECT x FROM DoctorAppointment x WHERE x.patientID = ?1")
    Optional<DoctorAppointment> findByPatientId(Integer patientID);

    //
    //@Query("SELECT x FROM DoctorAppointment x WHERE x.appointmentID = ?1")
    Optional<DoctorAppointment> findByAppointmentID(Integer appointmentID);
}
