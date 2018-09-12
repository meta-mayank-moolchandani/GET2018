package com.metacube.training.service.interfaces;

import com.metacube.training.model.ForgetPasswordToken;

public interface TokenService {
	 ForgetPasswordToken getToken(String empCode);
	 boolean insertToken(ForgetPasswordToken forgetPasswordToken);
	 boolean deleteToken(String empCode);
}
