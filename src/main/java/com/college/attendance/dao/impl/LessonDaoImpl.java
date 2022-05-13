package com.college.attendance.dao.impl;

import com.college.attendance.dao.LessonDao;
import com.college.attendance.entity.Lesson;
import com.college.attendance.repository.LessonRepository;
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
public class LessonDaoImpl implements LessonDao {
    final private LessonRepository lessonRepository;

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson findByDesc(String desc) {
        return lessonRepository.findByDesc(desc);
    }

    @Override
    public Optional<Lesson> findById(String lessonId) {
        return lessonRepository.findById(lessonId);
    }

    @Override
    public Lesson findByDescAndSubject(String desc, String subject) {
        return lessonRepository.findByDescAndSubject(desc, subject);
    }
}
