package com.example.studentcrudproject.api.impl;

import com.example.studentcrudproject.api.StudentApi;
import com.example.studentcrudproject.dto.StudentDTO;
import com.example.studentcrudproject.entity.Student;
import com.example.studentcrudproject.service.StudentService;
import com.example.studentcrudproject.utility.APIResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@CrossOrigin(origins = "*")
public class StudentApiController implements StudentApi {

	@Autowired
	private StudentService studentService;

	@Override
	public ResponseEntity<StudentDTO> get(int studentId) {
		return ResponseEntity.ok(studentService.get(studentId));


	}

	@Override
	public APIResponse create(StudentDTO studentDTO) {
		return studentService.create(studentDTO);
	}

	@Override
	public APIResponse getStudent() {
		return studentService.getStudent();

	}

	@Override
	public APIResponse getText(){
		return studentService.getText();
	}


	@Override
	public APIResponse update(StudentDTO studentDTO, int studentId) {
		return studentService.update(studentDTO, studentId);
	}

	@Override
	public APIResponse delete(int studentId) {
		return studentService.delete(studentId);
	}

    @Override
    public ResponseEntity<List<Student>> getN(String name) {
        return ResponseEntity.ok(studentService.getN(name));
    }

	@Override
	public ResponseEntity<List<Student>> getP(String phone) {
		return ResponseEntity.ok(studentService.getP(phone));
	}
}

