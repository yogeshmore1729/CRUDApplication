package com.yogesh.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yogesh.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
