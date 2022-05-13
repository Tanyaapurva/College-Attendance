package com.college.attendance.dao.impl;


import com.college.attendance.dao.StudentDao;
import com.college.attendance.entity.Student;
import com.college.attendance.repository.StudentRepository;
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
public class StudentDaoImpl implements StudentDao {
    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentRepository.getById(studentId);
    }

    @Override
    public Student findByFirstNameAndDob(String firstName, Date dob) {
        return studentRepository.findByFirstNameAndDob(firstName, dob);
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return studentRepository.findById(studentId);
    }
}
