package com.college.attendance.controller;

import com.college.attendance.dto.StudentCreateRequest;
import com.college.attendance.dto.StudentProfileRequest;
import com.college.attendance.service.StudentService;
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
@RequestMapping("/student")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController extends ExceptionController {

    private final Assets assets;
    private final StudentService studentService;

    @PostMapping(value = "/createStudent/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Save Student Details")
    public ResponseEntity<Object> saveStudent(@RequestBody StudentCreateRequest studentCreationRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, studentService.createStudent(studentCreationRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/viewStudentById/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Save Student Details")
    public ResponseEntity<Object> fetchStudent(@RequestBody StudentProfileRequest studentProfileRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, studentService.fetchStudent(studentProfileRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
