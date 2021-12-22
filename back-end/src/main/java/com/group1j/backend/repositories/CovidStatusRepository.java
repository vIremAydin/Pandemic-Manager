package com.group1j.backend.repositories;

import com.group1j.backend.entities.CovidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CovidStatusRepository extends JpaRepository<CovidStatus,Integer> {

    //@Query("SELECT x FROM CovidStatus x WHERE x.covidStatusID = ?1")
    Optional<CovidStatus> findById(Integer covidStatusID);
}
