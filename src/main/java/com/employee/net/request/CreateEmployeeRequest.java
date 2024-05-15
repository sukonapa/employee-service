package com.employee.net.request;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private long addressId;
	

}
