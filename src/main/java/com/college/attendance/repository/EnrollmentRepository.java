package com.college.attendance.repository;

import com.college.attendance.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {
    @Query(value = "select * from enrollment where lesson_id=:lessonId and student_id=:studentId limit 1", nativeQuery = true)
    Enrollment findByLessonIdAndStudentId(String lessonId, String studentId);
}
