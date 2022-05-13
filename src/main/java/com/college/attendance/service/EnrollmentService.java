package com.college.attendance.service;

import com.college.attendance.dto.EnrollmentRequest;
import com.college.attendance.response.EnrollmentResponse;

public interface EnrollmentService {
    EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest);
}
