package com.college.attendance.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentProfileResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private Date createdDate;
    private Date modifiedDate;
    private String fatherName;
    private String motherName;
    private String className;
    private String section;
    private String batch;
    private int mobileNo;
    private List<AttendanceResponse> attendance;
    private List<EnrollmentResponse> enrollment;

}
