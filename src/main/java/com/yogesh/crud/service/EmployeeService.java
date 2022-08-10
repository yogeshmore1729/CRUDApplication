package com.yogesh.crud.service;

import java.util.List;

import com.yogesh.crud.model.Employee;

public interface EmployeeService {

	//Save the employee data in the database a.k.a CREATE
	public Employee saveEmployee(Employee employee);
	
	//get all the employees data from the database as a List a.k.a READ
	public List<Employee> getAllEmployee();
	
	//get specific employee data by using Id a.k.a READ
	public Employee getEmployee(int Id);
	
	//Update the existing employee in the database a.k.a UPDATE
	public Employee updateEmployee(Employee employee, int Id);
	
	//Delete the employee record from the database a.k.a. DELETE
	public void deleteEmployee(int Id);
	
	


	
}
