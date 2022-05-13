package com.college.attendance.repository;

import com.college.attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceRepository extends JpaRepository<Attendance, String> {

    @Query(value = "select * from attendance where lesson_session_id=:lessonSessionId and student_id=:studentId limit 1", nativeQuery = true)
    Attendance findByLessonSessionIdAndStudentId(String lessonSessionId, String studentId);
}
