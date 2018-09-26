package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.EmployeeModel;

public interface EmployeeRepository<E> extends JpaRepository<EmployeeModel, String>{
	//public EmployeeModel findByEmailId(String emailId);
}
