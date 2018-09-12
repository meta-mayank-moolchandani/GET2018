package com.metacube.training.dao.interfaces;

import com.metacube.training.model.ForgetPasswordToken;

public interface TokenDAO {
 ForgetPasswordToken getToken(String empCode);
 boolean insertToken(ForgetPasswordToken forgetPasswordToken);
 boolean deleteToken(String empCode);
}
