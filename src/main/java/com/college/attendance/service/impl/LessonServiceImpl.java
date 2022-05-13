package com.college.attendance.service.impl;

import com.college.attendance.dao.LessonDao;
import com.college.attendance.dao.LessonSessionDao;
import com.college.attendance.dto.LessonCreateRequest;
import com.college.attendance.dto.LessonSessionCreateRequest;
import com.college.attendance.entity.Lesson;
import com.college.attendance.entity.LessonSession;
import com.college.attendance.entity.Teacher;
import com.college.attendance.exception.CollegeException;
import com.college.attendance.exception.ResponseCode;
import com.college.attendance.response.LessonCreateResponse;
import com.college.attendance.response.LessonSessionCreateResponse;
import com.college.attendance.service.LessonService;
import com.college.attendance.service.TeacherService;
import com.college.attendance.util.Utills;
import com.college.attendance.util.enums.RandomNumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonServiceImpl implements LessonService {
    final LessonDao lessonDao;
    final LessonSessionDao lessonSessionDao;
    final TeacherService teacherService;

    @Override
    public LessonCreateResponse createLesson(LessonCreateRequest lessionCreationRequest) {
        LessonCreateResponse response = new LessonCreateResponse();
        try {
            Lesson lesson = lessonDao.findByDescAndSubject(lessionCreationRequest.getDesc(), lessionCreationRequest.getSubject());
            if (Objects.nonNull(lesson)) {
                throw new CollegeException(ResponseCode.LESSON_ALREADY_EXIT);
            } else {
                lesson = new Lesson();
                lesson.setCreatedDate(new Date());
                lesson.setSubject(lessionCreationRequest.getSubject());
                lesson.setModifiedDate(new Date());
                lesson.setDesc(lessionCreationRequest.getDesc());
                lesson.setLessonId(RandomNumberGenerator.generateLessonId());
                lesson = lessonDao.save(lesson);
                response.setLessonId(lesson.getLessonId());
            }
        } catch (CollegeException e) {
            throw e;
        } catch (Exception e) {
            throw new CollegeException(ResponseCode.LESSON_SAVED_FAILURE);
        }
        return response;
    }

    @Override
    public LessonSessionCreateResponse createLessonSession(LessonSessionCreateRequest lessonSessionCreateRequest) {
        LessonSessionCreateResponse response = new LessonSessionCreateResponse();
        Teacher teacher = teacherService.findTeacherById(lessonSessionCreateRequest.getTeacherId());
        try {
            LessonSession lessonSession = lessonSessionDao.findByLessonId(lessonSessionCreateRequest.getLessonId());
            if (Objects.nonNull(lessonSession)) {
                throw new CollegeException(ResponseCode.LESSON_SESSION_ALREADY_EXIT);
            } else {
                lessonSession = new LessonSession();
                lessonSession.setLessonId(findLessonById(lessonSessionCreateRequest.getLessonId()));
                lessonSession.setTeacher(teacher);
                lessonSession.setStartTime(Utills.createStringToDate(lessonSessionCreateRequest.getStartTime()));
                lessonSession.setEndTime(Utills.createStringToDate(lessonSessionCreateRequest.getEndTime()));
                lessonSession.setLessonSessionId(RandomNumberGenerator.generateLessonSessionId());
                lessonSession.setCreatedDate(new Date());
                lessonSession.setModifiedDate(new Date());
                lessonSession = lessonSessionDao.save(lessonSession);
                response.setLessonSessionId(lessonSession.getLessonSessionId());
            }

        } catch (CollegeException e) {
            throw e;
        } catch (Exception e) {
            throw new CollegeException(ResponseCode.LESSON_SESSION_SAVED_FAILURE);
        }
        return response;
    }

    @Override
    public LessonSession findLessonSessionById(String lessonSessionId) {
        Optional<LessonSession> lessonSession = lessonSessionDao.findById(lessonSessionId);
        if (lessonSession.isPresent())
            return lessonSession.get();
        throw new CollegeException(ResponseCode.LESSON_SESSION_NOT_EXIT);
    }

    @Override
    public Lesson findLessonById(String lessonId) {
        Optional<Lesson> lesson = lessonDao.findById(lessonId);
        if (lesson.isPresent())
            return lesson.get();
        throw new CollegeException(ResponseCode.LESSON_NOT_EXIT);
    }
}
