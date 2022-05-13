package com.college.attendance.dao.impl;

import com.college.attendance.dao.TeacherDao;
import com.college.attendance.entity.Teacher;
import com.college.attendance.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class TeacherDaoImpl implements TeacherDao {

    final private TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher findByFirstNameAndDob(String firstName, Date teacherDob) {
        return teacherRepository.findByFirstNameAndDob(firstName, teacherDob);
    }

    @Override
    public Optional<Teacher> findById(String teacherId) {
        return teacherRepository.findById(teacherId);
    }
}
