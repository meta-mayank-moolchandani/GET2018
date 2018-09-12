package com.metacube.training.model;

public class ConfirmPassword {
	private String empCode;
	private String tokenId;
	private String newPassword;
	private String confirmPassword;

	
	@Override
	public String toString() {
		return "ConfirmPassword [empCode=" + empCode + ", tokenId=" + tokenId
				+ ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}

	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
