package com.group1j.backend.repositories;

import com.group1j.backend.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    //@Query("SELECT x FROM Instructor x WHERE x.id = ?1")
    Optional<Instructor> findById(Integer id);
}
