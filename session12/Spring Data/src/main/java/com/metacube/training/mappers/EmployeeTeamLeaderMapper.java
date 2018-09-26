package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeModel;

public class EmployeeTeamLeaderMapper implements RowMapper<EmployeeModel> {
		@Override
		public EmployeeModel mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setEmpCode(resultSet.getString("emp_code"));
		employeeModel.setFirstName(resultSet.getString("first_name"));
		return employeeModel;
		}

	

		}
