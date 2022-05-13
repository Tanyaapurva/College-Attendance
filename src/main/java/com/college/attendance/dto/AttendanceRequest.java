package com.college.attendance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendanceRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotNull
    private String lessonSessionId;
    @NotNull
    private String studentId;
    @NotNull
    @JsonProperty("isPresent")
    private boolean isPresent;
    private String reason;

}
