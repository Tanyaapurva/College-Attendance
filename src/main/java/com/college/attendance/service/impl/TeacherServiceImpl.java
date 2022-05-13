package com.college.attendance.service.impl;

import com.college.attendance.dao.TeacherDao;
import com.college.attendance.dto.TeacherCreationRequest;
import com.college.attendance.entity.Teacher;
import com.college.attendance.exception.CollegeException;
import com.college.attendance.exception.ResponseCode;
import com.college.attendance.response.TeacherCreationResponse;
import com.college.attendance.service.TeacherService;
import com.college.attendance.util.Utills;
import com.college.attendance.util.enums.RandomNumberGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServiceImpl implements TeacherService {
    final private TeacherDao teacherDao;

    @Override
    public TeacherCreationResponse createTeacher(TeacherCreationRequest teacherCreationRequest) {
        TeacherCreationResponse response = new TeacherCreationResponse();

        try {
            Date teacherDob = Utills.getFormetDOB(teacherCreationRequest.getDob());
            Teacher teacher = teacherDao.findByFirstNameAndDob(teacherCreationRequest.getFirstName(), teacherDob);
            if (Objects.nonNull(teacher)) {
                throw new CollegeException(ResponseCode.TEACHER_ALREADY_EXIT);

            } else {
                teacher = new Teacher();
                teacher.setFirstName(teacherCreationRequest.getFirstName());
                teacher.setMiddleName(teacherCreationRequest.getMiddleName());
                teacher.setLastName(teacherCreationRequest.getLastName());
                teacher.setDob(teacherDob);
                teacher.setGender(teacherCreationRequest.getGender());
                teacher.setMobileNo(teacherCreationRequest.getMobileNo());
                teacher.setSubject(teacherCreationRequest.getSubject());
                teacher.setCreatedDate(new Date());
                teacher.setModifiedDate(new Date());
                teacher.setTeacherId(RandomNumberGenerator.generateTeacherId());
                teacher = teacherDao.save(teacher);
                response.setTeacherId(teacher.getTeacherId());
            }
        } catch (CollegeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CollegeException(ResponseCode.TEACHER_SAVE_FAILED);

        }
        return response;

    }

    @Override
    public Teacher findTeacherById(String teacherId) {
        Optional<Teacher> teacher = teacherDao.findById(teacherId);
        if (teacher.isPresent())
            return teacher.get();
        throw new CollegeException(ResponseCode.TEACHER_NOT_EXIT);


    }

}
