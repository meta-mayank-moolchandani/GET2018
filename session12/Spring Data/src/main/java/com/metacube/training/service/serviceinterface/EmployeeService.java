package com.metacube.training.service.serviceinterface;

import java.util.List;

import com.metacube.training.model.EmployeeModel;

import com.metacube.training.transferObjects.EmployeeForgotPassword;
import com.metacube.training.transferObjects.EmployeeSkills;
import com.metacube.training.transferObjects.EmployeeTransferObject;
import com.metacube.training.transferObjects.EmployeeTransferObjectWithJobDetails;

public interface EmployeeService {
	EmployeeModel getEmployeeById(String empCode);

	List<EmployeeTransferObject> getAllEmployeeTransferObjects();
	
	List<EmployeeModel> getAllEmployees();

	boolean disableEmployee(String empCode);
	
    boolean enableEmployee(String empCode);

	boolean updateEmployee(EmployeeModel employeeModel);

	boolean createEmployee(EmployeeTransferObjectWithJobDetails employeeTransferObject);

	boolean createJobDetails(EmployeeTransferObjectWithJobDetails employeeTransferObject);

	List<EmployeeModel> getTeamLeaders();

	List<EmployeeModel> getManagers();

	EmployeeModel findUserByEmail(String employeeEmail);

	boolean saveForgotEmployee(EmployeeForgotPassword employeeForgotPassword);

	EmployeeForgotPassword findUserByResetToken(String token);

	boolean deleteToken(String token);

	boolean addSkills(EmployeeSkills employee);

}
