package com.discover.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
