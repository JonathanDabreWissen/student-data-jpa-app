package com.example.demo.repos.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Student;

public interface StudentPostgresRepository extends JpaRepository<Student, Integer> {
}
