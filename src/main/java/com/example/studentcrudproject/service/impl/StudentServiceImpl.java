package com.example.studentcrudproject.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.type.descriptor.java.SerializableTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcrudproject.dto.StudentDTO;
import com.example.studentcrudproject.entity.Student;
import com.example.studentcrudproject.repository.StudentRepository;
import com.example.studentcrudproject.service.StudentService;
import com.example.studentcrudproject.utility.APIResponse;

@Service
public class StudentServiceImpl implements StudentService {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public StudentDTO get(int studentId) {
        Student student = studentRepository.findById(studentId);
        return getStudentDTO(student);
    }

    @Override
    public APIResponse create(StudentDTO studentDTO) {
        System.out.println(studentDTO.toString());
        Student s = getStudentEntity(studentDTO);
        Student student = studentRepository.save(s);
        return new APIResponse("success", student);
    }

    @Override
    public APIResponse getStudent() {
        List<Student> l = studentRepository.findAll();
        List<StudentDTO> newList = new ArrayList<>();
        if ((!l.isEmpty())) {
            newList = l.stream().map(this::getStudentDTO).collect(Collectors.toList());
        }
        return new APIResponse("success", newList);
    }

    @Override
    public APIResponse update(StudentDTO studentDTO, int studentId) {
        Student student = studentRepository.findById(studentId);
        studentRepository.save(student);
        return new APIResponse("success", studentId);
    }

    @Override
    public APIResponse delete(int studentId) {
        Student student = studentRepository.findById(studentId);
        studentRepository.delete(student);
        return new APIResponse("success", "student deleted successfully!");
    }

    @Override
    public List<Student> getN(String name) {
        List<Student> student = studentRepository.findByName(name);
        return student;
    }

    @Override
    public List<Student> getP(String phone) {

        List<Student> student = studentRepository.findByPhone(phone);
        return student;
    }

    private Student getStudentEntity(StudentDTO studentDTO) {
        return mapper.convertValue(studentDTO, Student.class);
    }

    private StudentDTO getStudentDTO(Student student) {
        return mapper.convertValue(student, StudentDTO.class);
    }
}

