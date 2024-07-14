package com.employee.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.net.entity.Employee;
import com.employee.net.repository.EmployeeRepository;
import com.employee.net.request.CreateEmployeeRequest;
import com.employee.net.response.AddressResponse;
import com.employee.net.response.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public EmployeeResponse createEmployeeDetails(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = new Employee();
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		employee.setEmail(createEmployeeRequest.getEmail());

		employee.setAddressId(createEmployeeRequest.getAddressId());
		employee = employeeRepository.save(employee);
		// save employee details in db
		EmployeeResponse employeeResponse = new EmployeeResponse(employee);
		employeeResponse.setAddress(getAddressById(employee.getAddressId()));
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).get();
		EmployeeResponse employeeResponse = new EmployeeResponse(employee);
		employeeResponse.setAddress(getAddressById(employee.getAddressId()));
		return employeeResponse;
	}

	@Value("${address.service.url}")
	private String addressServiceUrl;
	
	public AddressResponse getAddressById(long addressId) {
		

		String uri = addressServiceUrl+"/get/" + addressId;
		RestTemplate restTemplate = new RestTemplate();
		AddressResponse addressResponse = restTemplate.getForObject(uri, AddressResponse.class);
		System.out.println("Address Response : " + addressResponse);
		return addressResponse;
	}

}
