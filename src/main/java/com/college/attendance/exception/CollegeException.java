package com.college.attendance.exception;

import lombok.Data;

import java.util.function.Supplier;


@Data
public class CollegeException extends RuntimeException implements Supplier<CollegeException> {
    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private Throwable messageTrace;
    private Object errorMessages;

    public CollegeException(String errorCode, String errorMessage,
                            Throwable messageTrace) {
        this.code = errorCode;
        this.message = errorMessage;
        this.messageTrace = messageTrace;
    }
    public CollegeException(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.message = errorMessage;
    }
    public CollegeException(String errorCode, String errorMessage,
                            Throwable messageTrace, Object errorMessages) {
        this.code = errorCode;
        this.message = errorMessage;
        this.messageTrace = messageTrace;
        this.errorMessages = errorMessages;
    }

    public CollegeException(Throwable messageTrace, ResponseCode responseCode, Object... arguments) {
        this(responseCode, arguments);
        this.messageTrace = messageTrace;
    }

    public CollegeException(ResponseCode responseCode, Object... arguments) {
        this.code = String.valueOf(responseCode.getCode());
        this.message = String.format(responseCode.getDescription(), arguments);
    }

    public CollegeException(Throwable messageTrace, ResponseCode responseCode) {
        this(responseCode);
        this.messageTrace = messageTrace;
    }

    public CollegeException(ResponseCode responseCode) {
        this.code = String.valueOf(responseCode.getCode());
        this.message = responseCode.getDescription();
    }

    public CollegeException(Object errorMessages, ResponseCode responseCode, Object... arguments) {
        this(responseCode, arguments);
        this.errorMessages = errorMessages;
    }


    @Override
    public CollegeException get() {
        return this;
    }
}
