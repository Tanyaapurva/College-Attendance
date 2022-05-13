package com.college.attendance.dao.impl;


import com.college.attendance.dao.AttendanceDao;
import com.college.attendance.entity.Attendance;
import com.college.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AttendanceDaoImpl implements AttendanceDao {

    final private AttendanceRepository attendanceRepository;

    @Override
    public Attendance findByLessonSessionIdAndStudentId(String lessonSessionId, String studentId) {
        return attendanceRepository.findByLessonSessionIdAndStudentId(lessonSessionId, studentId);
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}
