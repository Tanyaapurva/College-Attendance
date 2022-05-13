package com.college.attendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "teacher")
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "teacher_id")
    private String teacherId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "subject")
    private String subject;

    @Column(name = "mobile_number")
    private int mobileNo;


    @OneToMany(mappedBy = "teacher")
    private List<LessonSession> lessonSession;

}
