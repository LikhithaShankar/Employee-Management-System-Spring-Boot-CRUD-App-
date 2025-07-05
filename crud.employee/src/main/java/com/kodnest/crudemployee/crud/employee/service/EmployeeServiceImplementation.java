package com.kodnest.crudemployee.crud.employee.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.crudemployee.crud.employee.entity.Employee;
import com.kodnest.crudemployee.crud.employee.repository.EmployeeRepository;



	@Service
	public class EmployeeServiceImplementation implements EmployeeService {
		@Autowired
		EmployeeRepository repo;

		public void createNewEmployee(Employee emp) {
			repo.save(emp);
		}
		
		public Employee searchEmployee(Long id) {
		    return repo.findById(id).orElse(null); // ✅ Safely handles "not found"
		}
		
		public void updateEmployee(Employee emp) {
			repo.save(emp);
		}
		
		/*
		 * public void deleteEmployee(Long id) { repo.deleteById(id); }
		 */
		
		public void deleteEmployee(Long id) {
		    if (repo.existsById(id)) {
		        repo.deleteById(id);
		    }
		}
		
		public List<Employee> getAllEmployees() {
		    return repo.findAll();
		}


	}
