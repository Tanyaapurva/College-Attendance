package com.college.attendance.controller;

import com.college.attendance.dto.TeacherCreationRequest;
import com.college.attendance.dto.TeacherProfileRequest;
import com.college.attendance.service.TeacherService;
import com.college.attendance.util.Assets;
import com.college.attendance.constant.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherController extends ExceptionController {

    private final Assets assets;

    private final TeacherService teacherService;

    @PostMapping(value = "/createTeacher/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Save Student Details")
    public ResponseEntity<Object> saveTeacher(@RequestBody TeacherCreationRequest teacherCreationRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, teacherService.createTeacher(teacherCreationRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

        @PostMapping(value = "/viewTeacher/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "view teacher details")
        public ResponseEntity<Object> findTeacherById(@RequestBody TeacherProfileRequest teacherProfileRequest) {
            Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, teacherService.findTeacherById(teacherProfileRequest.getTeacherId()));
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}