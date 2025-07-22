package com.test_spring.demo_spring.service;

import com.test_spring.demo_spring.entity.Student;

import java.util.List;

public interface IStudentService {
    Student save(Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    void update(Student theStudent);
    void delete(int id);
}
