package com.group1j.backend.repositories;

import com.group1j.backend.entities.CovidStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidStatusRepository extends JpaRepository<CovidStatus,Integer> {
}
