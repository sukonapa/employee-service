package com.employee.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.employee.net.request.CreateEmployeeRequest;
import com.employee.net.response.EmployeeResponse;
import com.employee.net.service.EmployeeService;

@RestController
@RequestMapping("v1/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public EmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		
		return employeeService.createEmployeeDetails(createEmployeeRequest);
		
	}
	
	

	@GetMapping("get/{id}")
	public EmployeeResponse getEmployee(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}
}
