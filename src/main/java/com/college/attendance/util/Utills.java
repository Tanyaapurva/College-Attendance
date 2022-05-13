package com.college.attendance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Utills {
    public static Date getFormetDOB(String dob) throws ParseException {
        Date dateWithoutTime = null;
        if (Objects.isNull(dob)) {
            dob = "1990-01-01";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateWithoutTime = sdf.parse(dob);
        return dateWithoutTime;
    }

    public static Date createStringToDate(String date) throws ParseException {
        Date dateWithoutTime = null;
        if (Objects.isNull(date)) {
            date = "01-01-1990 12:00:00";
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return format.parse(date);

    }

    public static String getCutomDate(Date dob) {
        if (Objects.isNull(dob))
            return "1990-01-01";
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dob);
        // dateTextView.setText(dateOnly);
    }
}
