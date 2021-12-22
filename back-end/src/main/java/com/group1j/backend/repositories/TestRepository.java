package com.group1j.backend.repositories;

import com.group1j.backend.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

    //@Query("SELECT x FROM Test x WHERE x.testID = ?1")
    Optional<Test> findByTestId(Integer testID);

    //@Query("SELECT x FROM Test x WHERE x.patientID = ?1")
    Optional<Test> findByPatientID(Integer patientID);
}
