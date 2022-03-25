package net.dtt.spring.Models.ViewModels;

import java.sql.Date;

public class RegisterRequestModel {
	private String Name;
	private int Gender;
	private Date BirthDay;
	private String Email;
	private String Token;
	private String Phone;
	private String Address;
	
	public RegisterRequestModel() {
		
	}

	public RegisterRequestModel(String name, int gender, Date birthDay, String email, String token, String phone,
			String address) {
		Name = name;
		Gender = gender;
		BirthDay = birthDay;
		Email = email;
		Token = token;
		Phone = phone;
		Address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getGender() {
		return Gender;
	}

	public void setGender(int gender) {
		Gender = gender;
	}

	public Date getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
}
