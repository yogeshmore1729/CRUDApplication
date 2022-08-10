package com.yogesh.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.crud.model.Employee;
import com.yogesh.crud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return ResponseEntity.ok().body(emp);
	}
	
	//Read all the employees from database
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	//Read only one Employee from database 
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int Id){
		Employee emp = employeeService.getEmployee(Id);
		return ResponseEntity.ok().body(emp);
	}
	
	//Update the employee using id in database
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int Id, @RequestBody Employee employee){
		Employee emp = employeeService.updateEmployee(employee, Id);
		return ResponseEntity.ok(emp);
	}
	
	//Delete the employee using id in database
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int Id) {
		//Delete the employee by using the Id 
		employeeService.deleteEmployee(Id);
		return ResponseEntity.ok("Employee Deleted Successfully.");
	}

}
