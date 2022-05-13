package com.college.attendance.repository;

import com.college.attendance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, String> {
    Lesson findByDesc(String desc);

    Lesson findByDescAndSubject(String desc, String subject);
}
