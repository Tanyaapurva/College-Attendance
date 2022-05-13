package com.college.attendance.service;

import com.college.attendance.dto.TeacherCreationRequest;
import com.college.attendance.dto.TeacherProfileRequest;
import com.college.attendance.entity.Teacher;
import com.college.attendance.response.TeacherCreationResponse;

public interface TeacherService {
    TeacherCreationResponse createTeacher(TeacherCreationRequest teacherCreationRequest);

    Teacher findTeacherById(String teacherId);

}
