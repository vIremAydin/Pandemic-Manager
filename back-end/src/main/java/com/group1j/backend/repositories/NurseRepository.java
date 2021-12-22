package com.group1j.backend.repositories;

import com.group1j.backend.entities.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepository extends JpaRepository<Nurse,Integer> {

    //@Query("SELECT x FROM Nurse x WHERE x.id = ?1")
    Optional<Nurse> findById(Integer id);
}
