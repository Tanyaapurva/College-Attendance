package com.college.attendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "attendance")
@Data
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "attendance_id")
    private String attendanceId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_session_id", referencedColumnName = "lesson_session_id")
    private LessonSession lessonSession;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "reason")
    private String reason;
    @Column(name = "is_present")
    private boolean isPresent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

}
