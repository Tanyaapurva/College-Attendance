package com.college.attendance.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String status;
    private String attendanceId;
    private String reason;
    private boolean isPresent;

}