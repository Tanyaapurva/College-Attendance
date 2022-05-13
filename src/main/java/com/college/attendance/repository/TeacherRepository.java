package com.college.attendance.repository;

import com.college.attendance.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query(value = "select * from teacher where first_name=:firstName and dob=:teacherDob limit 1", nativeQuery = true)
    Teacher findByFirstNameAndDob(String firstName, Date teacherDob);
}
