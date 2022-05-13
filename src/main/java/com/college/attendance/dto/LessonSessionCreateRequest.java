package com.college.attendance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LessonSessionCreateRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotNull
    private String lessonId;
    private String startTime;
    private String endTime;
    @NotNull
    private String teacherId;

}