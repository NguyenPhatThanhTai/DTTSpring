package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminDaoModel implements Serializable {
	private int Id;
	private String Name;
	private int Phone;
	private String Address;
	private String Email;
	private String Password;
	private int Level;
	
	public AdminDaoModel() {
		
	}
	
	public AdminDaoModel(int id, String name, int phone, String address, String email, String password, int level) {
		this.Id = id;
		this.Name = name;
		this.Phone = phone;
		this.Address = address;
		this.Email = email;
		this.Password = password;
		this.Level = level;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	
	@Column(name = "name", length = 50, nullable = true)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name = "phone", length = 11, nullable = true)
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	
	@Column(name = "address", nullable = true)
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	@Id
	@Column(name = "email", length = 50, nullable = false)
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@Column(name = "password", length = 50, nullable = true)
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Column(name = "level", length = 1, nullable = true)
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	
	
}
