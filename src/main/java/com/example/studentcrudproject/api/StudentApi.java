package com.example.studentcrudproject.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentcrudproject.dto.StudentDTO;
import com.example.studentcrudproject.entity.Student;
import com.example.studentcrudproject.utility.APIResponse;

public interface StudentApi {


    @GetMapping(value = "/student/get/{student-id}", produces = {"application/json"})
    ResponseEntity<StudentDTO> get(@PathVariable(value = "student-id", required = true) int studentId);

    @PostMapping(value = "/student/create", produces = {"application/json"})
    APIResponse create(@RequestBody StudentDTO studentDTO);

    @GetMapping(value = "/students/get", produces = {"application/json"})
    APIResponse getStudent();

    @PutMapping(value = "/student/update/{student-id}", produces = {"application/json"})
    APIResponse update(@RequestBody StudentDTO studentDTO, @PathVariable(required = true) int studentId);

    @DeleteMapping(value = "/student/delete/{student-id}")
    APIResponse delete(@PathVariable(value = "student-id", required = true) int studentId);

    @GetMapping(value = "/student/gets", produces = {"application/json"})
    ResponseEntity<List<Student>> getN(@RequestParam(name = "name") String name);

    @GetMapping(value = "/student/get", produces = {"application/json"})
    ResponseEntity<List<Student>> getP(@RequestParam(value = "phone") String phone);


}