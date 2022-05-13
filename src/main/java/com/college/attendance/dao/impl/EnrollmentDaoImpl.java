package com.college.attendance.dao.impl;


import com.college.attendance.dao.EnrollmentDao;
import com.college.attendance.entity.Enrollment;
import com.college.attendance.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class EnrollmentDaoImpl implements EnrollmentDao {
    final private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment findByLessonIdAndStudentId(String lessonId, String studentId) {
        return enrollmentRepository.findByLessonIdAndStudentId(lessonId, studentId);
    }
}
