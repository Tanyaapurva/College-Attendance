package com.college.attendance.controller;

import com.college.attendance.dto.EnrollmentRequest;
import com.college.attendance.service.EnrollmentService;
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
@RequestMapping("/enrollment")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnrollmentController extends ExceptionController {

    private final Assets assets;

    private final EnrollmentService enrollmentService;

    @PostMapping(value = "/enrollStudent/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Enroll Lesson")
    public ResponseEntity<Object> saveTeacher(@RequestBody EnrollmentRequest enrollmentRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, enrollmentService.createEnrollment(enrollmentRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}