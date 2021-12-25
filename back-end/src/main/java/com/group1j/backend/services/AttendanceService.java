package com.group1j.backend.services;

import com.group1j.backend.entities.Attendance;
import com.group1j.backend.entities.Course;
import com.group1j.backend.entities.Student;
import com.group1j.backend.repositories.AttendanceRepository;
import com.group1j.backend.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceService {
    //Fields
    private AttendanceRepository attendanceRepository;
    private StudentRepository studentRepository;

    //Constructor
    public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    public AttendanceRepository getAttendanceRepository() {
        return attendanceRepository;
    }

    public void setAttendanceRepository(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * This method accepts students who enter the attendance code correctly
     * @param attendanceID
     * @param studentID
     * @return
     */
    public Attendance addStudent(int attendanceID, int studentID) {
        Optional<Student> student = studentRepository.findById(studentID);
        Optional<Attendance> attendance = attendanceRepository.findByAttendanceID(attendanceID);

        if(student.isPresent() && attendance.isPresent()){
            Student s = student.get();
            Attendance a = attendance.get();

            a.getActiveStudents().add(s.getId());
            attendanceRepository.save(a);
            return a;
        }

        return null;
    }
}
