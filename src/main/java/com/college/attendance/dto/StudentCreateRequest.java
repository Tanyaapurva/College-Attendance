package com.college.attendance.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentCreateRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;
    @NotNull
    private String dob;
    private String gender;
    private Date createdDate;
    private Date modifiedDate;
    @NotNull
    private String fatherName;
    private String motherName;
    private String className;
    private String section;
    private String batch;
    private int mobileNo;

}
