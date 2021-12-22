package com.group1j.backend.repositories;

import com.group1j.backend.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    //@Query("SELECT x FROM Doctor x WHERE x.id = ?1")
    Optional<Doctor> findById(Integer id);
}
