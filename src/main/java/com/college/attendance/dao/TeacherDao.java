package com.college.attendance.dao;

import com.college.attendance.entity.Teacher;

import java.util.Date;
import java.util.Optional;

public interface TeacherDao {
    Teacher save(Teacher teacher);

    Teacher findByFirstNameAndDob(String firstName, Date teacherDob);

    Optional<Teacher> findById(String teacherId);
}
