package com.test_spring.demo_spring.rest;

import com.test_spring.demo_spring.entity.Student;
import com.test_spring.demo_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestControler {

    private StudentService studentService;

    @Autowired
    public DemoRestControler(StudentService theStudentService)
    {
        studentService = theStudentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID)
    {
        Student student = studentService.findById(studentID);

        if(student == null)
        {
            throw new StudentNotFoundException("Student id not found : "+studentID);
        }

        return student;
    }

    //@PostMapping()

}
