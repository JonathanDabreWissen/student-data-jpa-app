package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/h2/{rollNo}")
    public ResponseEntity<Student> getStudentFromH2(@PathVariable Integer rollNo) {
        Student student = studentService.getStudentFromH2(rollNo);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @GetMapping("/postgres/{rollNo}")
    public ResponseEntity<Student> getStudentFromPostgres(@PathVariable Integer rollNo) {
        Student student = studentService.getStudentFromPostgres(rollNo);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer rollNo) {
        studentService.deleteStudent(rollNo);
        return ResponseEntity.ok().build();
    }
}