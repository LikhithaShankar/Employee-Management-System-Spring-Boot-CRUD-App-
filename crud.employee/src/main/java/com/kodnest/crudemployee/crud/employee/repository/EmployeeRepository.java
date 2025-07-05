package com.kodnest.crudemployee.crud.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.crudemployee.crud.employee.entity.Employee;

public interface EmployeeRepository 
		extends JpaRepository<Employee, Long>	{

}
