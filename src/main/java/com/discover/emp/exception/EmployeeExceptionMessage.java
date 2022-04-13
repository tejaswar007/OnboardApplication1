package com.discover.emp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeExceptionMessage implements EmployeeException{
    private int statusCode;
    private Date timestamp;
    private String message;
	private String requestedURI;
}