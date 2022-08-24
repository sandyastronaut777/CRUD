package com.example.studentcrudproject.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse {

	private int statusCode;
	private String status;
	private String message;
	private Object object;
	
	public APIResponse() {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.object = object;
	}
	
	public APIResponse(String message, Object object) {
		super();
		this.statusCode = 200;
		this.status = "Success";
		this.message = message;
		this.object = object;
	}
	
	
}
