package com.group1j.backend.repositories;

import com.group1j.backend.entities.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRecordRepository extends JpaRepository<TestRecord,Integer> {
}
