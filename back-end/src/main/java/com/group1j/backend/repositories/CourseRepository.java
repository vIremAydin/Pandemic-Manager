package com.group1j.backend.repositories;

import com.group1j.backend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    //@Query("SELECT x FROM Course x WHERE x.courseID = ?1")
    Optional<Course> findById(Integer courseID);
}
