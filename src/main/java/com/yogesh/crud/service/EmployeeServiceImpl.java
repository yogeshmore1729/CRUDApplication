package com.yogesh.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogesh.crud.exception.ResourceNotFoundException;
import com.yogesh.crud.model.Employee;
import com.yogesh.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int Id) {
		 Optional<Employee> employee = employeeRepository.findById(Id);
		 if(employee.isPresent()) {
			 return employee.get();
		 } else {
			 throw new ResourceNotFoundException("Employee Not Found in the Database.");
		 }
	}

	@Override
	public Employee updateEmployee(Employee employee, int Id) {

		Optional<Employee> emp = employeeRepository.findById(Id);
		if(emp.isPresent()) {
			Employee e=emp.get();
			e.setName(employee.getName());
			e.setCity(employee.getCity());
			Employee savedEmploee = employeeRepository.save(e);
			return savedEmploee;
		} else {
			throw new ResourceNotFoundException("Employee Not Found in the Database");	
		}
		
	}

	@Override
	public void deleteEmployee(int Id) {

		// check if the employee exist or not
		Optional<Employee> optionalEmp = employeeRepository.findById(Id);
		if(optionalEmp.isPresent()) {
			// if present then delete the employee by using Id 
			employeeRepository.deleteById(Id);
			System.out.println("Employee Deleted Successfully.");
		} else {
			//throw custom exception using following way
			throw new ResourceNotFoundException("Employee Not Found in the Database.");
		}
		
	}

	
	

	
}
