package com.employee.net.response;

import com.employee.net.entity.Employee;

import lombok.Data;


@Data
public class EmployeeResponse {
	
	private long id;
	
	private String firstName;

	
	private String lastName;
	
	private String email;
	
	private AddressResponse address;
	
	public EmployeeResponse(Employee employee) {
		this.id=employee.getId();
		this.firstName=employee.getFirstName();
		this.lastName=employee.getLastName();
		this.email=employee.getEmail();

	}

}
