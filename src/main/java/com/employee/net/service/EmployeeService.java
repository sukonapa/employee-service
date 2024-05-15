package com.employee.net.service;

import com.employee.net.request.CreateEmployeeRequest;
import com.employee.net.response.EmployeeResponse;

public interface EmployeeService {

	public EmployeeResponse createEmployeeDetails(CreateEmployeeRequest createEmployeeRequest);
	
	public EmployeeResponse getEmployeeById(long id);
}
