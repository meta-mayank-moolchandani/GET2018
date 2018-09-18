package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;

public interface EmployeeRepository<E> extends JpaRepository<Employee, String>{
	//public EmployeeModel findByEmailId(String emailId);
	
	@Query("select * from Employee where jobTitle=:title")
	public List<Employee> getJobTitle(@Param("title") String jobTitle );
	
	@Query("select * from Employee where skills=:skillName")
	public List<Employee> getEmployeeBySkill(@Param("skillName") String skills );

	public Employee getLastAddedEmployee();

}
