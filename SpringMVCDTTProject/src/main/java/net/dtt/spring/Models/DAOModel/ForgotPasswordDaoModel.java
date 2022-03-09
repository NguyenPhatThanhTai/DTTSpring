package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forgot_password")
public class ForgotPasswordDaoModel implements Serializable{
	private int Customer_id;
	private String Token;
	private Date CreateAt;
	
	
	
	public ForgotPasswordDaoModel() {
		super();
	}

	public ForgotPasswordDaoModel(int customer_id, String token, Date createAt) {
		super();
		Customer_id = customer_id;
		Token = token;
		CreateAt = createAt;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	
	@Column(name = "token", length = 255, nullable = false)
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	
	@Column(name = "create_at", nullable = false)
	public Date getCreateAt() {
		return CreateAt;
	}
	public void setCreateAt(Date createAt) {
		CreateAt = createAt;
	}
}
