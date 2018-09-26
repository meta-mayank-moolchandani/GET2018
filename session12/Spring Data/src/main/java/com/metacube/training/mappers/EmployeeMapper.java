package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeModel;
import com.metacube.training.model.Project;

public class EmployeeMapper implements RowMapper<EmployeeModel> {

	@Override
	public EmployeeModel mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setFirstName(resultSet.getString("first_name"));
		employeeModel.setLastName(resultSet.getString("last_name"));
		employeeModel.setDob(resultSet.getDate("dob"));
		employeeModel.setEmailId(resultSet.getString("email_id"));
		employeeModel.setEmpCode(resultSet.getString("emp_code"));
		employeeModel.setDateOfJoining(resultSet.getDate("doj"));
		employeeModel.setContactNumber(resultSet.getString("primary_contact_number"));
		employeeModel.setPassword(resultSet.getString("password"));
		employeeModel.setGender(resultSet.getString("gender"));
		return employeeModel;
	}

	
}
