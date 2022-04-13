package com.discover.emp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.discover.emp.entity.Employee;
import com.discover.emp.service.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmployeeApplication.class)
public class EmpApplicationTests {
	   @MockBean
	   private EmployeeServiceImpl employeeService;
	   
	   @Test
	   public void createEmployee() throws Exception {
		  Employee employee = getEmployee().get();
	      Mockito.when(employeeService.createEmploye(employee)).thenReturn(employee);
	      Employee result = employeeService.createEmploye(employee);
	      assertEquals(result.getEmployeeId(),111l);	
	   }
	   
	   
	   @Test
	   public void fetchEmployee() throws Exception {
		  Optional<Employee> employee = getEmployee();
	      Mockito.when(employeeService.fetchEmployee(111l)).thenReturn(employee);
	      Optional<Employee> result = employeeService.fetchEmployee(111l);
	      assertEquals(result.get().getEmployeeName(),"Tej");	
	   }

	   
	   private Optional<Employee> getEmployee() {
		      Employee employee = new Employee();
		      employee.setEmployeeId(111l);
		      employee.setEmployeeName("Tej");
		      employee.setEmployeeSalary(111111.00);
		      Optional<Employee> employeeOpt = Optional.of(employee);
		      return employeeOpt;
		   }
}