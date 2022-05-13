package com.college.attendance.dao;

import com.college.attendance.entity.LessonSession;

import java.util.Optional;

public interface LessonSessionDao {
    LessonSession findByLessonId(String lessonId);

    LessonSession save(LessonSession lessonSession);

    Optional<LessonSession> findById(String lessonSessionId);
}
