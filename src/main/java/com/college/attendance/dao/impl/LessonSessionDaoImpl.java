package com.college.attendance.dao.impl;

import com.college.attendance.dao.LessonSessionDao;
import com.college.attendance.entity.LessonSession;
import com.college.attendance.repository.LessonSessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonSessionDaoImpl implements LessonSessionDao {
    final private LessonSessionRepository lessonSessionRepository;

    @Override
    public LessonSession findByLessonId(String lessonId) {
        return lessonSessionRepository.findByLessonId(lessonId);
    }

    @Override
    public LessonSession save(LessonSession lessonSession) {
        return lessonSessionRepository.save(lessonSession);
    }

    @Override
    public Optional<LessonSession> findById(String lessonSessionId) {
        return lessonSessionRepository.findById(lessonSessionId);
    }
}
