package com.college.attendance.service;

import com.college.attendance.dto.LessonCreateRequest;
import com.college.attendance.dto.LessonSessionCreateRequest;
import com.college.attendance.entity.Lesson;
import com.college.attendance.entity.LessonSession;
import com.college.attendance.response.LessonCreateResponse;
import com.college.attendance.response.LessonSessionCreateResponse;

public interface LessonService {
    LessonCreateResponse createLesson(LessonCreateRequest lessionCreationRequest);

    LessonSessionCreateResponse createLessonSession(LessonSessionCreateRequest lessonSessionCreateRequest);

    LessonSession findLessonSessionById(String lessonSessionId);

    Lesson findLessonById(String lessonId);
}
