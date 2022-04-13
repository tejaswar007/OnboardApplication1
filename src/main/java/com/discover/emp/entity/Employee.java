package com.discover.emp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name= "EmployeePrimaryDetails")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class Employee {	@Id
	private Long employeeId;
	@NotEmpty
	private String employeeName;
	@NotNull
	private  Double employeeSalary;
}
