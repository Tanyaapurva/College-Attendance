package com.college.attendance.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lesson")
@Data
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "lesson_id")
    private String lessonId;
    @Column(name = "description")
    private String desc;

    @Column(name = "subject")
    private String subject;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @OneToOne(mappedBy = "lessonId")
    private Enrollment enrollment;

    @OneToOne(mappedBy = "lessonId")
    private LessonSession lessonSession;

}
