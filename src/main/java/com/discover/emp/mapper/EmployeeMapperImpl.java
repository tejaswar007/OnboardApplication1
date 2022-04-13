package com.discover.emp.mapper;

import com.discover.emp.dto.EmployeeDTO;
import com.discover.emp.entity.Employee;
import com.discover.emp.entity.Employee.EmployeeBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-08T19:28:37+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.12 (Eclipse Foundation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO getEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeId( employee.getEmployeeId() );
        employeeDTO.setEmployeeName( employee.getEmployeeName() );
        employeeDTO.setEmployeeSalary( employee.getEmployeeSalary() );

        return employeeDTO;
    }

    @Override
    public Employee getEmployee(EmployeeDTO employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.employeeId( employeeDto.getEmployeeId() );
        employee.employeeName( employeeDto.getEmployeeName() );
        employee.employeeSalary( employeeDto.getEmployeeSalary() );

        return employee.build();
    }
}
