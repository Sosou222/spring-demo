package com.test_spring.demo_spring.service;

import com.test_spring.demo_spring.dao.StudentDAO;
import com.test_spring.demo_spring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO theStudentDAO)
    {
        studentDAO = theStudentDAO;
    }

    @Override
    @Transactional
    public Student save(Student theStudent) {
        return studentDAO.save(theStudent);
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        studentDAO.update(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        studentDAO.delete(id);
    }
}
