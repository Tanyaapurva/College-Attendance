package com.college.attendance.dao;

import com.college.attendance.entity.Enrollment;

public interface EnrollmentDao {
    Enrollment save(Enrollment enrollment);

    Enrollment findByLessonIdAndStudentId(String lessonId, String studentId);
}
