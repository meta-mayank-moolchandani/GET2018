package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.ForgetPasswordToken;

public class TokenMapper implements RowMapper<ForgetPasswordToken>{

	@Override
	public ForgetPasswordToken mapRow(ResultSet resultSet, int i) throws SQLException {
		ForgetPasswordToken forgetPasswordToken = new ForgetPasswordToken();
		forgetPasswordToken.setEmpCode(resultSet.getString("emp_code"));
		forgetPasswordToken.setToken(resultSet.getString("token"));
		return forgetPasswordToken;
	}
	

}
