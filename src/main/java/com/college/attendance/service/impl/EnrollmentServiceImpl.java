package com.college.attendance.service.impl;

import com.college.attendance.dao.EnrollmentDao;
import com.college.attendance.dto.EnrollmentRequest;
import com.college.attendance.entity.Enrollment;
import com.college.attendance.entity.Lesson;
import com.college.attendance.entity.Student;
import com.college.attendance.exception.CollegeException;
import com.college.attendance.exception.ResponseCode;
import com.college.attendance.response.EnrollmentResponse;
import com.college.attendance.service.EnrollmentService;
import com.college.attendance.service.LessonService;
import com.college.attendance.service.StudentService;
import com.college.attendance.util.enums.RandomNumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnrollmentServiceImpl implements EnrollmentService {
    final private EnrollmentDao enrollmentDao;
    final private StudentService studentService;
    final private LessonService lessonService;

    @Override
    public EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest) {
        EnrollmentResponse response = new EnrollmentResponse();
        try {
            Student student = studentService.findStudentById(enrollmentRequest.getStudentId());
            Lesson lesson = lessonService.findLessonById(enrollmentRequest.getLessonId());
            Enrollment enrollment = enrollmentDao.findByLessonIdAndStudentId(enrollmentRequest.getLessonId(), enrollmentRequest.getStudentId());

            if (Objects.nonNull(enrollment)) {

            } else {
                enrollment = new Enrollment();
                enrollment.setCreatedDate(new Date());
                enrollment.setModifiedDate(new Date());
                enrollment.setStudent(student);
                enrollment.setLessonId(lesson);
                enrollment.setEnrollmentId(RandomNumberGenerator.generateEnrollmentId());
                enrollment = enrollmentDao.save(enrollment);
                response.setEnrollmentId(enrollment.getEnrollmentId());
            }
        } catch (CollegeException e) {
            throw e;
        } catch (Exception e) {
            throw new CollegeException(ResponseCode.ENROLLMENT_SAVED_FAILURE);
        }
        return response;
    }
}
