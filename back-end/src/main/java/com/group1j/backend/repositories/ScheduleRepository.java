package com.group1j.backend.repositories;

import com.group1j.backend.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    //@Query("SELECT x FROM Schedule x WHERE x.scheduleID = ?1")
    Optional<Schedule> findById(Integer scheduleID);
}
