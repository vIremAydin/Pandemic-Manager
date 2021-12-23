package com.group1j.backend.repositories;

import com.group1j.backend.entities.VaccinationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VaccinationStatusRepository extends JpaRepository<VaccinationStatus,Integer> {

    //@Query("SELECT x FROM VaccinationStatus x WHERE x.vaccinationStatusID = ?1")
    Optional<VaccinationStatus> findByVaccinationStatusID(Integer vaccinationStatusID);
}
