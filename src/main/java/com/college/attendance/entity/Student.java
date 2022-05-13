package com.college.attendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@Data
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;


    @Column(name = "class")
    private String className;


    @Column(name = "section")
    private String section;


    @Column(name = "batch")
    private String batch;

    @Column(name = "mobile_number")
    private int mobileNo;


    @OneToMany(mappedBy = "student")
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollment;

}
