package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Student;
import com.example.demo.repos.h2.StudentH2Repository;
import com.example.demo.repos.postgres.StudentPostgresRepository;

@Service
public class StudentService {

    @Autowired
    private StudentH2Repository h2Repository;

    @Autowired
    private StudentPostgresRepository postgresRepository;

    @Transactional
    public Student addStudent(Student student) {
        // Save to H2
        Student h2Student = h2Repository.save(student);
        
        // Save to PostgreSQL
        Student pgStudent = postgresRepository.save(student);
        
        return h2Student;
    }

    public Student getStudentFromH2(Integer rollNo) {
        return h2Repository.findById(rollNo).orElse(null);
    }

    public Student getStudentFromPostgres(Integer rollNo) {
        return postgresRepository.findById(rollNo).orElse(null);
    }

    @Transactional
    public void deleteStudent(Integer rollNo) {
        h2Repository.deleteById(rollNo);
        postgresRepository.deleteById(rollNo);
    }
}