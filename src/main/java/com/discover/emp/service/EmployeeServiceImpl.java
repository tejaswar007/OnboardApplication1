package com.discover.emp.service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.discover.emp.dao.EmployeeRepository;
import com.discover.emp.entity.Employee;
import com.discover.emp.exception.EmployeeAlreadyExistsException;
import com.discover.emp.exception.EmployeeNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmploye(Employee employee) throws EmployeeAlreadyExistsException{
		if (employeeRepository.existsById(employee.getEmployeeId())) {
			logger.error("EmployeeServiceImpl::createEmploye::Employee Already Exists::::{}",employee.getEmployeeId());
			throw new EmployeeAlreadyExistsException("Employee Already Exists::"+employee.getEmployeeId());
		}
		logger.debug("EmployeeServiceImpl::createEmploye::Employee created successfully::::{}",employee.getEmployeeId());
		return employeeRepository.save(employee);
	}
	
	@Override
	public Optional<Employee> fetchEmployee(Long empId) throws EmployeeNotFoundException {
		Optional<Employee> response = employeeRepository.findById(empId);
		if (response.isPresent()) {
			logger.debug("EmployeeServiceImpl::fetchEmployee::Employee fetched successfully::::{}",response.get());
			return response;
		}
		logger.error("EmployeeServiceImpl::fetchEmployee::Employee Not Found::::{}",empId);
		throw new EmployeeNotFoundException("Employee Not Found::" + empId);
	}
}
