package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Student;
import com.example.demo.repos.h2.StudentH2Repository;
import com.example.demo.repos.postgres.StudentPostgresRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentH2Repository h2Repo;

    @Autowired
    private StudentPostgresRepository pgRepo;
    

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        h2Repo.save(student); // Save to H2
        pgRepo.save(student); // Save to PostgreSQL
        return "Student added to both databases!";
    }
}
