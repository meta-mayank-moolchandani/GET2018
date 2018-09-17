package com.metacube.training.dao.daointerfaces;

import java.util.List;
import java.util.Optional;

import com.metacube.training.model.EmployeeModel;

import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;


public interface EmployeeDAO {
	
	EmployeeModel getEmployeeById(String empCode);

	List<EmployeeModel> getAllEmployees();
	
	List<EmployeeTransferObject> getAllEmployeeTransferObjects();

	boolean disableEmployee(String empCode);

	boolean enableEmployee(String empCode);

	boolean createEmployee(EmployeeTransferObjectWithJobDetails employee);
	
	String getLastEmployeeCode();

	boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject);

	List<EmployeeModel> getTeamLeaders();

	List<EmployeeModel> getManagers();

	EmployeeModel findUserByEmail(String employeeEmail);

	boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword);

	EmployeeForgotPassword findUserByResetToken(String token);

	boolean updateEmployee(EmployeeModel employeeModel);

	boolean deleteToken(String token);
}
