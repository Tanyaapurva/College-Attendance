package com.college.attendance.service.impl;

import com.college.attendance.dao.AttendanceDao;
import com.college.attendance.dto.AttendanceRequest;
import com.college.attendance.entity.Attendance;
import com.college.attendance.entity.LessonSession;
import com.college.attendance.entity.Student;
import com.college.attendance.exception.CollegeException;
import com.college.attendance.exception.ResponseCode;
import com.college.attendance.response.AttendanceResponse;
import com.college.attendance.service.AttendanceService;
import com.college.attendance.service.LessonService;
import com.college.attendance.service.StudentService;
import com.college.attendance.util.enums.RandomNumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AttendanceServiceImpl implements AttendanceService {
    final private AttendanceDao attendanceDao;
    final private StudentService studentService;
    final private LessonService lessonService;

    @Override
    public AttendanceResponse addAttendance(AttendanceRequest attendanceRequest) {
        AttendanceResponse response = new AttendanceResponse();
        try {
            Student student = studentService.findStudentById(attendanceRequest.getStudentId());
            LessonSession lessonSession = lessonService.findLessonSessionById(attendanceRequest.getLessonSessionId());
            Attendance attendance = attendanceDao.findByLessonSessionIdAndStudentId(attendanceRequest.getLessonSessionId(), attendanceRequest.getStudentId());
            log.info("attendance request {}", attendanceRequest);
            if (Objects.nonNull(attendance)) {
                throw new CollegeException(ResponseCode.ATTENDANCE_ALREADY_DONE);
            } else {
                attendance = new Attendance();
                attendance.setPresent(attendanceRequest.isPresent());
                attendance.setReason(attendanceRequest.getReason());
                attendance.setStudent(student);
                attendance.setLessonSession(lessonSession);
                attendance.setAttendanceId(RandomNumberGenerator.generateAttendanceId());
                attendance = attendanceDao.save(attendance);
                response.setAttendanceId(attendance.getAttendanceId());
            }
        } catch (CollegeException e) {
            throw e;
        } catch (Exception e) {
            throw new CollegeException(ResponseCode.ATTENDANCE_SAVED_FAILURE);
        }
        return response;
    }
}
