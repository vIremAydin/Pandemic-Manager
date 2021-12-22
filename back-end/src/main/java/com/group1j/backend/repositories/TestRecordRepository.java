package com.group1j.backend.repositories;

import com.group1j.backend.entities.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRecordRepository extends JpaRepository<TestRecord,Integer> {

    //@Query("SELECT x FROM TestRecord x WHERE x.testRecordID = ?1")
    Optional<TestRecord> findByTestRecordId(Integer testRecordID);
}
