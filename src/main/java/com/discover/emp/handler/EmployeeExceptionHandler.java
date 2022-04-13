package com.discover.emp.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.discover.emp.exception.EmployeeException;
import com.discover.emp.exception.EmployeeExceptionMessage;
import com.discover.emp.exception.EmployeeAlreadyExistsException;
import com.discover.emp.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public EmployeeException handleEmployeeNotFoundxception(EmployeeNotFoundException employeeNotFoundException, final HttpServletRequest request) {
		return new EmployeeExceptionMessage(HttpStatus.NOT_FOUND.value(), new Date(), employeeNotFoundException.getMessage(),request.getRequestURI());
	}
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
    public EmployeeException handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException employeeAlreadyExistsException,final HttpServletRequest request) {
		return new EmployeeExceptionMessage(HttpStatus.CONFLICT.value(), new Date(), employeeAlreadyExistsException.getMessage(),request.getRequestURI());
    }

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public EmployeeException handleAllExceptions(Exception ex, final HttpServletRequest request) {
		return new EmployeeExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(),request.getRequestURI());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public  EmployeeException  handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
	return new EmployeeExceptionMessage(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),request.getRequestURI());
	
	}
}
