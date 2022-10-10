package com.example.studentcrudproject.service;

import java.util.List;

import com.example.studentcrudproject.dto.StudentDTO;
import com.example.studentcrudproject.entity.Student;
import com.example.studentcrudproject.utility.APIResponse;

public interface StudentService {

    StudentDTO get(int studentId);

    APIResponse create(StudentDTO studentDTO);

    APIResponse getStudent();

    APIResponse update(StudentDTO studentDTO, int studentId);

    APIResponse delete(int studentId);

    List<Student> getN(String name);

    List<Student> getP(String phone);

}
 