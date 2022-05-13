package com.college.attendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "enrollment")
@Data
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class Enrollment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "enrollment_id")
    private String enrollmentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    private Lesson lessonId;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

}