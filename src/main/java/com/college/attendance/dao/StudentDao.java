package com.college.attendance.dao;

import com.college.attendance.entity.Student;

import java.util.Date;
import java.util.Optional;

public interface StudentDao {
    Student save(Student student);

    Student findByStudentId(String studentId);

    Student findByFirstNameAndDob(String firstName, Date dob);

    Optional<Student> findById(String studentId);
}
