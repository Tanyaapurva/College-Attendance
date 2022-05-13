package com.college.attendance.service;

import com.college.attendance.dto.StudentCreateRequest;
import com.college.attendance.dto.StudentProfileRequest;
import com.college.attendance.entity.Student;
import com.college.attendance.response.StudentCreateResponse;
import com.college.attendance.response.StudentProfileResponse;

public interface StudentService {
    StudentCreateResponse createStudent(StudentCreateRequest cartRequestBean);

    StudentProfileResponse fetchStudent(StudentProfileRequest studentProfileRequest);

    Student findStudentById(String studentId);
}
