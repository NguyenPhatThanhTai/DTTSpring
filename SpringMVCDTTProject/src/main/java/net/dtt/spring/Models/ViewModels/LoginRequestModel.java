package net.dtt.spring.Models.ViewModels;

public class LoginRequestModel {
	private String Email;
	private String Password;
	
	public LoginRequestModel() {
		super();
	}
	
	public LoginRequestModel(String email, String password) {
		super();
		Email = email;
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
