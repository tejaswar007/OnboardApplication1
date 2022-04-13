package com.discover.emp.dto;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	@Id
	private Long employeeId;
	private String employeeName;
	private  Double employeeSalary;
}
