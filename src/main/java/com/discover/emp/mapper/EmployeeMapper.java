package com.discover.emp.mapper;

import org.mapstruct.Mapper;
import com.discover.emp.dto.EmployeeDTO;
import com.discover.emp.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	EmployeeDTO getEmployeeDTO(Employee employee);
	Employee getEmployee(EmployeeDTO employeeDto);
}
