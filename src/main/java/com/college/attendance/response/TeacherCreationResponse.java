package com.college.attendance.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherCreationResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String status;
    private String teacherId;
}