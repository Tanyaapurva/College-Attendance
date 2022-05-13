package com.college.attendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lesson_session")
@Data
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "lesson_session_id")
    private String lessonSessionId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    private Lesson lessonId;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "start_datetime")
    private Date startTime;

    @Column(name = "end_datetime")
    private Date endTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

    @OneToOne(mappedBy = "lessonSession")
    private Attendance attendance;
}
