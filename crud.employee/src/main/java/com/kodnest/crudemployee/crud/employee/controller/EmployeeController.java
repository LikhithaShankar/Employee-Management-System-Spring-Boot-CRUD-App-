package com.kodnest.crudemployee.crud.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.crudemployee.crud.employee.entity.Employee;
import com.kodnest.crudemployee.crud.employee.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	/*
	 * @PostMapping("/create") public void createNewEmployee(@ModelAttribute
	 * Employee emp) { service.createNewEmployee(emp); }
	 * 
	 * @PostMapping("/update") public void updateEmployee(@ModelAttribute Employee
	 * emp) { service.updateEmployee(emp); }
	 * 
	 * @PostMapping("/delete") public void deleteEmployee(@ModelAttribute Long id) {
	 * service.deleteEmployee(id); }
	 */
	/*
	 * @GetMapping("/search") public Employee searchEmployee(Long id) { Employee emp
	 * = service.searchEmployee(id); System.out.println(emp); return emp; }
	 */
	
	@PostMapping("/create")
	public String createNewEmployee(@ModelAttribute Employee emp, Model model) {
	    service.createNewEmployee(emp);
	    model.addAttribute("message", "Employee created successfully!");
	    return "create";
	}
    
	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam Long id, Model model) {
	    service.deleteEmployee(id);
	    model.addAttribute("message", "Employee deleted successfully!");
	    return "delete";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee emp, Model model) {
	    service.updateEmployee(emp);
	    model.addAttribute("message", "Employee updated successfully!");
	    return "update"; // This loads update.html page with message
	}

	@GetMapping("/search")
	public String searchEmployee(@RequestParam Long id, Model model) {
	    Employee emp = service.searchEmployee(id);
	    if (emp == null) {
	        model.addAttribute("error", "Employee not found!");
	    } else {
	        model.addAttribute("employee", emp);
	    }
	    return "search";
	}
	
	@GetMapping("/list")
	public String listAllEmployees(Model model) {
	    List<Employee> employees = service.getAllEmployees();
	    model.addAttribute("employees", employees);
	    return "list";  // refers to list.html
	}



	@GetMapping("/createPage")
	public String createPage() {
		return "create";	//create.html
	}
	@GetMapping("/searchPage")
	public String searchPage() {
		return "search";	//search.html
	}
	@GetMapping("/updatePage")
	public String updatePage() {
		return "update";	//update.html
	}
	@GetMapping("/deletePage")
	public String deletePage() {
		return "delete";	//delete.html
	}
	
}



