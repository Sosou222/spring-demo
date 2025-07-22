package com.test_spring.demo_spring.dao;

import com.test_spring.demo_spring.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAO(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }
    @Override
    public Student save(Student theStudent) {

        return entityManager.merge(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    public void delete(int id) {
        Student student = entityManager.find(Student.class,id);

        entityManager.remove(student);
    }
}
