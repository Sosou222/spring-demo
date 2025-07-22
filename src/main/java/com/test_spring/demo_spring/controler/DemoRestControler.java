package com.test_spring.demo_spring.controler;

import com.test_spring.demo_spring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestControler {

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        List<Student> list = new ArrayList<>();

        list.add(new Student("a","a","a@gmail.com"));
        list.add(new Student("b", "d", "d@gmail.com"));
        list.add(new Student("c","f","f@gmail.com"));

        return list;
    }

    @GetMapping("/studetns/{studentID}")
    public Student getStudent(@PathVariable  int studentID)
    {
        return new Student("a","a","a");
    }
}
