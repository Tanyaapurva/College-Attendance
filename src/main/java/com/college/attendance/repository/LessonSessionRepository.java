package com.college.attendance.repository;

import com.college.attendance.entity.LessonSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LessonSessionRepository extends JpaRepository<LessonSession, String> {
    @Query(value = "select * from lesson_session where lesson_id=:lessonId limit 1", nativeQuery = true)
    LessonSession findByLessonId(String lessonId);
}
