package com.discover.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(HttpStatus.CONFLICT)
@NoArgsConstructor

public class EmployeeAlreadyExistsException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
}

