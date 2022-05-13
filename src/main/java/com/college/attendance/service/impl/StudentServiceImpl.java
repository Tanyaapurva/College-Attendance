package com.college.attendance.service.impl;


import com.college.attendance.dao.StudentDao;
import com.college.attendance.dto.StudentCreateRequest;
import com.college.attendance.dto.StudentProfileRequest;
import com.college.attendance.entity.Attendance;
import com.college.attendance.entity.Enrollment;
import com.college.attendance.entity.Student;
import com.college.attendance.exception.CollegeException;
import com.college.attendance.exception.ResponseCode;
import com.college.attendance.response.AttendanceResponse;
import com.college.attendance.response.EnrollmentResponse;
import com.college.attendance.response.StudentCreateResponse;
import com.college.attendance.response.StudentProfileResponse;
import com.college.attendance.service.StudentService;
import com.college.attendance.util.Utills;
import com.college.attendance.util.enums.RandomNumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Override
    public StudentCreateResponse createStudent(StudentCreateRequest studentCreationRequest) {
        StudentCreateResponse response = new StudentCreateResponse();
        try {
            Date studentDob = Utills.getFormetDOB(studentCreationRequest.getDob());
            Student student = studentDao.findByFirstNameAndDob(studentCreationRequest.getFirstName(), studentDob);
            //  Student student=new Student();
            if (Objects.nonNull(student)) {
                throw new CollegeException(ResponseCode.STUDENT_ALREADY_EXIT);
            } else {
                student = new Student();
                student.setFirstName(studentCreationRequest.getFirstName());
                student.setMiddleName(studentCreationRequest.getMiddleName());
                student.setLastName(studentCreationRequest.getLastName());
                student.setBatch(studentCreationRequest.getBatch());
                student.setDob(studentDob);
                student.setFatherName(studentCreationRequest.getFatherName());
                student.setGender(studentCreationRequest.getGender());
                //  student.setSection(studentCreationRequest.);
                student.setMobileNo(studentCreationRequest.getMobileNo());
                student.setMotherName(studentCreationRequest.getMotherName());
                student.setCreatedDate(new Date());
                student.setModifiedDate(new Date());
                student.setFirstName(studentCreationRequest.getFirstName());
                student.setStudentId(RandomNumberGenerator.generateStudentId());
                student = studentDao.save(student);
                response.setStudentId(student.getStudentId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CollegeException(ResponseCode.STUDENT_SAVE_FAILED);
        }
        return response;

    }

    @Override
    public StudentProfileResponse fetchStudent(StudentProfileRequest studentProfileRequest) {
        StudentProfileResponse response = new StudentProfileResponse();
      try{
            Optional<Student> studentdate = studentDao.findById(studentProfileRequest.getStudentId());
       if(!studentdate.isPresent()){
           throw new CollegeException(ResponseCode.STUDENT_NOT_EXIT);
       }
       Student student=studentdate.get();
        response.setFirstName(student.getFirstName());
        response.setStudentId(student.getStudentId());
        response.setFatherName(student.getFatherName());
        response.setLastName(student.getLastName());

        response.setDob(Utills.getCutomDate(student.getDob()));
        response.setMiddleName(student.getMiddleName());
        response.setAttendance(setAttendance(student.getAttendance()));
        response.setEnrollment(setEnrollment(student.getEnrollment()));
      } catch (Exception e) {
          e.printStackTrace();
          throw new CollegeException(ResponseCode.INTERNAL_SERVER_ERROR);
      }
        return response;
    }

    private List<EnrollmentResponse> setEnrollment(List<Enrollment> enrollments) {
        List<EnrollmentResponse> enrollmentResponses = new ArrayList<>();
        enrollments.forEach(entity -> {
            EnrollmentResponse enrollment = EnrollmentResponse.builder().enrollmentId(entity.getEnrollmentId()).build();
            enrollmentResponses.add(enrollment);
        });
        return enrollmentResponses;
    }

    private List<AttendanceResponse> setAttendance(List<Attendance> attendances) {
        List<AttendanceResponse> attendanceRespons = new ArrayList<>();
        attendances.forEach(entity -> {
            AttendanceResponse enrollment = AttendanceResponse.builder().attendanceId(entity.getAttendanceId()).
                    isPresent(entity.isPresent()).reason(entity.getReason())
                    .build();
            attendanceRespons.add(enrollment);
        });
        return attendanceRespons;

    }

    @Override
    public Student findStudentById(String studentId) {
        Optional<Student> student = studentDao.findById(studentId);
        if (student.isPresent())
            return student.get();
        throw new CollegeException(ResponseCode.STUDENT_NOT_EXIT);

    }

}
