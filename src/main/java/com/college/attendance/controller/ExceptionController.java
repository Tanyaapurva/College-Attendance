package com.college.attendance.controller;

import com.college.attendance.exception.CollegeException;
import com.college.attendance.response.CollageApiResponse;
import com.college.attendance.constant.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;


@Controller
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);


    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<CollageApiResponse> ioExceptionHandler(
            IOException ex) {
        String message = AppConstants.EXCEPTION_MSG;
        LOGGER.error(message, ex);

        CollageApiResponse response = getFinalResponse(ex.getMessage(),
                Objects.toString(AppConstants.Codes.STATUS_FAILURE), null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CollageApiResponse> dbesRunTimException(
            RuntimeException ex) {
        String message = AppConstants.EXCEPTION_MSG;
        LOGGER.error(message, ex);

        CollageApiResponse response = getFinalResponse(message,
                Objects.toString(AppConstants.Codes.STATUS_FAILURE), null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {CollegeException.class})
    public ResponseEntity<CollageApiResponse> dbesApiExceptionHandler(
            CollegeException ex) {
        String message = ex.getMessage();
        String errorCode = ex.getCode();
        Object errors = ex.getErrorMessages();
        LOGGER.error(message, ex);

        CollageApiResponse response = getFinalResponse(message, errorCode,
                errors, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CollageApiResponse> handleException(Exception e) throws Exception {
        LOGGER.error("bad request error: ", e);
        return new ResponseEntity<>(getFinalResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), String.valueOf(HttpStatus.BAD_REQUEST.value()),
                null, null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CollageApiResponse> handle(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(getFinalResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), String.valueOf(HttpStatus.BAD_REQUEST.value()),
                exception.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()), null), HttpStatus.BAD_REQUEST);
    }

    private CollageApiResponse getFinalResponse(String errorMsg,
                                                String errorCode, Object errors, String internalErrorMsg) {

        CollageApiResponse response = new CollageApiResponse();
        try {
            response.setStatus(Integer.parseInt(errorCode));
        } catch (Exception e) {
            response.setStatus(AppConstants.Codes.STATUS_FAILURE);
        }
        response.setMessage(errorMsg);
        response.setData(errors);
        response.setInternalErrorMsg(internalErrorMsg);
        return response;

    }


}
