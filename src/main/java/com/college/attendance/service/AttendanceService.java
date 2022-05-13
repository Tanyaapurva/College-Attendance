package com.college.attendance.service;

import com.college.attendance.dto.AttendanceRequest;
import com.college.attendance.response.AttendanceResponse;

public interface AttendanceService {
    AttendanceResponse addAttendance(AttendanceRequest attendenceRequest);
}
