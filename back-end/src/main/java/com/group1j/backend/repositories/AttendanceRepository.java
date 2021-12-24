package com.group1j.backend.repositories;

import com.group1j.backend.entities.Attendance;
import com.group1j.backend.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
    Optional<Attendance> findByAttendanceID(Integer attendanceID);
}
