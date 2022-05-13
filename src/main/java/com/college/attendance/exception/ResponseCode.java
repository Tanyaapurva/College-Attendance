package com.college.attendance.exception;

public enum ResponseCode {

    GENERIC(1, "%s"),

    SUCCESS(200, "SUCCESS"),
    INTERNAL_SERVER_ERROR(5000, "Your request could not be served by the system. Please try again!"),
    ATTENDANCE_ALREADY_DONE(2, "Student attendance already done for that lesson"),
    LESSON_SESSION_NOT_EXIT(3, "Lesson Session not exit"),
    LESSON_NOT_EXIT(4, "Lesson not exit"),
    STUDENT_NOT_EXIT(5, "Student not exit"),
    TEACHER_NOT_EXIT(6, "Teacher not exit"),
    STUDENT_SAVE_FAILED(7, "Student save failed"),
    TEACHER_SAVE_FAILED(8, "Teacher save failed"),
    TEACHER_ALREADY_EXIT(9, "Teacher already exit"),
    STUDENT_ALREADY_EXIT(10, "Teacher already exit"),
    LESSON_ALREADY_EXIT(11, "Lesson already exit"),
    LESSON_SESSION_ALREADY_EXIT(12, "Lesson session already exit"),
    LESSON_SESSION_SAVED_FAILURE(13, "Lesson session saved failure"),
    LESSON_SAVED_FAILURE(14, "Lesson saved failure"),
    ATTENDANCE_SAVED_FAILURE(15, "Attendance saved failure"),
    ENROLLMENT_SAVED_FAILURE(16, "Enrollment saved failure");
    private int code;
    private String description;

    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public ResponseCode getCode(final int code) {
        for (final ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode() == code) {
                return responseCode;
            }
        }
        return INTERNAL_SERVER_ERROR;
    }

    public ResponseCode getResponseCodeByMessage(final String message) {
        for (final ResponseCode responseCode : ResponseCode.values()) {
            if (message.equals(responseCode.getDescription())) {
                return responseCode;
            }
        }
        return INTERNAL_SERVER_ERROR;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}