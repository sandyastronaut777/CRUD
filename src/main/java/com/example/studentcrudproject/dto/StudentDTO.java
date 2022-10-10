package com.example.studentcrudproject.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDTO {
	
	private int id;
	private String name;
	private String phone;
	private String email;
	private String createdBy;
	private String  status;

}
