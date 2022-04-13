package com.discover.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.discover.emp.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
