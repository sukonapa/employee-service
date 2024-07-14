package com.employee.net.repository;


import org.springframework.stereotype.Repository;

import com.employee.net.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
