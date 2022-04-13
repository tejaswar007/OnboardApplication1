package com.discover.emp.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.discover.emp.entity.Employee;
import com.discover.emp.mapper.EmployeeMapper;
import com.discover.emp.dto.EmployeeDTO;
import com.discover.emp.service.EmployeeServiceImpl;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@Validated
@RequestMapping(value ="/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeServiceImpl  employeeService;
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@PostMapping("/createEmployee")
    @RateLimiter(name = "createEmployeeRateLimit", fallbackMethod = "createEmployeeFallBack")
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDto) {
		Employee employee= employeeMapper.getEmployee(employeeDto);
		employeeService.createEmploye(employee);
		return new ResponseEntity<EmployeeDTO>(employeeDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchEmployee/{empId}")
	public ResponseEntity<EmployeeDTO> fetchEmployee(@PathVariable @Min(111) @Max(222) Long empId) {
		Optional<Employee> fetchedEmployee= employeeService.fetchEmployee(empId);
		EmployeeDTO employeeDTO = employeeMapper.getEmployeeDTO(fetchedEmployee.get());
		return new ResponseEntity<EmployeeDTO>(employeeDTO,HttpStatus.OK);
	}
	
	 public ResponseEntity<String> createEmployeeFallBack(RequestNotPermitted exception) {
         logger.info("Rate limit has applied, So no further calls are getting accepted");
         return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
         .body("Too many requests : No further request will be accepted. Please try after sometime");
     }
}
