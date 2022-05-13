package com.college.attendance.dao;

import com.college.attendance.entity.Lesson;

import java.util.Optional;

public interface LessonDao {
    Lesson save(Lesson lesson);

    Lesson findByDesc(String desc);

    Optional<Lesson> findById(String lessonId);

    Lesson findByDescAndSubject(String desc, String subject);
}
