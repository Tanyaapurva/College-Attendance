package com.college.attendance.controller;

import com.college.attendance.dto.LessonCreateRequest;
import com.college.attendance.dto.LessonSessionCreateRequest;
import com.college.attendance.service.LessonService;
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
@RequestMapping("/lesson")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonController extends ExceptionController {

    private final Assets assets;

    private final LessonService lessonService;

    @PostMapping(value = "/createLesson/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Save Lesson")
    public ResponseEntity<Object> saveLesson(@RequestBody LessonCreateRequest lessionCreationRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, lessonService.createLesson(lessionCreationRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/createSession/v1", produces = {"application/json"}, consumes = {"application/json"}, name = "Save Lesson Session")
    public ResponseEntity<Object> saveLessonSession(@RequestBody LessonSessionCreateRequest lessonSessionCreateRequest) {
        Object response = assets.generateResponseObj(AppConstants.Codes.STATUS_SUCCESS, AppConstants.API_EXECUTION_SUCCESS_MSG, lessonService.createLessonSession(lessonSessionCreateRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}