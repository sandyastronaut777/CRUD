package com.example.studentcrudproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcrudproject.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findById(int studentId);

    List<Student> findByName(String name);

    List<Student> findByPhone(String phone);
}
