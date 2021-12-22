package com.group1j.backend.repositories;

import com.group1j.backend.entities.TestAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestAppointmentRepository extends JpaRepository<TestAppointment,Integer> {

    //@Query("SELECT x FROM TestAppointment x WHERE x.patientID = ?1")
    Optional<TestAppointment> findByPatientId(Integer patientID);

    //inherited
    //@Query("SELECT x FROM TestAppointment x WHERE x.appointmentID = ?1")
    Optional<TestAppointment> findByAppointmentID(Integer appointmentID);
}
