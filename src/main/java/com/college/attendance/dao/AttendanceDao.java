package com.college.attendance.dao;

import com.college.attendance.entity.Attendance;

public interface AttendanceDao {
    Attendance findByLessonSessionIdAndStudentId(String lessonSessionId, String studentId);

    Attendance save(Attendance attendance);
}
