package com.test_spring.demo_spring;

import com.test_spring.demo_spring.dao.StudentDAO;
import com.test_spring.demo_spring.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner ->
		{
			CreateStudents(studentDAO);
		};
	}

	private void CreateStudents(StudentDAO studentDAO)
	{
		Student s1 = new Student("Ema","Bear","ema@gmail.com");
		Student s2 = new Student("Lay","Mouse","lay@gmail.com");
		Student s3 = new Student("Kale","Rat","kale@gmail.com");

		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
	}

}
