package com.college.attendance.util.enums;

import java.io.Serializable;

public class RandomNumberGenerator implements Serializable {

    public static String generateStudentId() {
        return "STU" + getRandomNumber();
    }

    public static String generateTeacherId() {
        return "TEA" + getRandomNumber();
    }

    public static String generateLessonId() {
        return "LESS" + getRandomNumber();
    }

    public static String generateLessonSessionId() {
        return "SESS" + getRandomNumber();
    }

    public static String generateEnrollmentId() {
        return "ENR" + getRandomNumber();
    }

    public static String

    generateAttendanceId() {
        return "ATE" + getRandomNumber();
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 100000);
    }
}
