package com.discover.emp.service;

import java.util.Optional;
import com.discover.emp.entity.Employee;
import com.discover.emp.exception.EmployeeAlreadyExistsException;
import com.discover.emp.exception.EmployeeNotFoundException;

public interface EmployeeService {
	Employee  createEmploye(Employee employee) throws EmployeeAlreadyExistsException;
	Optional<Employee>  fetchEmployee(Long empId) throws EmployeeNotFoundException;
}
