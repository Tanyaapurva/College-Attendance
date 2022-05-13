package com.college.attendance.controller;

import com.college.attendance.dto.AttendanceRequest;
import com.college.attendance.service.AttendanceService;
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
@RequestMapping("/attendance")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AttendanceController extends ExceptionController {

    private final Assets assets;

    private final AttendanceService attendanceService;

    @PostMapping(value = "/addAttendance/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Save Student Details")
    public ResponseEntity<Object> addAttendance(@RequestBody AttendanceRequest attendenceRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, attendanceService.addAttendance(attendenceRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}