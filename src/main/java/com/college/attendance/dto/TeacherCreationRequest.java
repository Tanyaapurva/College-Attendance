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
public class TeacherCreationRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;
    private Date createdDate;
    private Date modifiedDate;
    private String subject;
    @NotNull
    private int mobileNo;
    @NotNull
    private String dob;
    private String gender;


}
