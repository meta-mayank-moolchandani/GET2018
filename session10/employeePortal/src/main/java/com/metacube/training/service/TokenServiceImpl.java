package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.TokenDAO;
import com.metacube.training.model.ForgetPasswordToken;
import com.metacube.training.service.interfaces.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
	
	@Autowired
	private TokenDAO tokenDao;

	@Override
	public ForgetPasswordToken getToken(String empCode) {
		// TODO Auto-generated method stub
		return tokenDao.getToken(empCode);
	}

	@Override
	public boolean insertToken(ForgetPasswordToken forgetPasswordToken) {
		return tokenDao.insertToken(forgetPasswordToken);
	}
	

	@Override
	public boolean deleteToken(String empCode) {
		return tokenDao.deleteToken(empCode);
	}

}
