package com.college.attendance.repository;

import com.college.attendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "select * from student where first_name=:firstName and dob=:dob limit 1", nativeQuery = true)
    Student findByFirstNameAndDob(String firstName, Date dob);
}
