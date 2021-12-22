package com.group1j.backend.repositories;

import com.group1j.backend.entities.VaccinationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationStatusRepository extends JpaRepository<VaccinationStatus,Integer> {
}
