package com.test_spring.demo_spring.dao;

import com.test_spring.demo_spring.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO implements IStudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAO(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
