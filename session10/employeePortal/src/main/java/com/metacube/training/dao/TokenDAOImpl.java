package com.metacube.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.interfaces.TokenDAO;
import com.metacube.training.mappers.TokenMapper;
import com.metacube.training.model.ForgetPasswordToken;


@Repository
public class TokenDAOImpl implements TokenDAO {
	
    private final String GET_EMPLOYEE_TOKEN = "SELECT * FROM token WHERE emp_code = ? ";
    
    private final String INSERT_TOKEN = "INSERT INTO token VALUES(?, ?);";
    
    private final String DELETE_TOKEN = "delete from token where emp_code = ? ;";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	TokenDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public ForgetPasswordToken getToken(String empCode) {
		try{
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_TOKEN, new Object[]{empCode},new TokenMapper());
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean insertToken(ForgetPasswordToken forgetPasswordToken) {
		try{
		return jdbcTemplate.update(INSERT_TOKEN,forgetPasswordToken.getEmpCode(),forgetPasswordToken.getToken())>0;
		}catch(Exception e){
			return false;
		}
	}


	@Override
	public boolean deleteToken(String empCode) {
		return jdbcTemplate.update(DELETE_TOKEN,empCode)>0;
	}

}
