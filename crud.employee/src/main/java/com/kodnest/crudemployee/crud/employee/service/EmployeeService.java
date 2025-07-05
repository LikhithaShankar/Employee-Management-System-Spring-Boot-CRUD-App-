package com.kodnest.crudemployee.crud.employee.service;

import java.util.List;

import com.kodnest.crudemployee.crud.employee.entity.Employee;

public interface EmployeeService {
			
		void createNewEmployee(Employee emp);
		
		Employee searchEmployee(Long id);
		
	
		void updateEmployee(Employee emp);

		
		void deleteEmployee(Long id);
		
		List<Employee> getAllEmployees();

	}

