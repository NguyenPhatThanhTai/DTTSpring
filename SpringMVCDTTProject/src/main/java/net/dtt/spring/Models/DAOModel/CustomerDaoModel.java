package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.dtt.spring.entity.Two;

@Entity
@Table(name = "customer")
public class CustomerDaoModel implements Serializable {
	private int Id;
	private String Name;
	private int Gender;
	private Date BirthDay;
	private String Email;
	private String Token;
	private String Phone;
	private String Address;
	private Set<CommentProductDaoModel> commentProduct = new HashSet<CommentProductDaoModel>();
	private Set<OrdersDaoModel> orderDao = new HashSet<OrdersDaoModel>();
	
	public CustomerDaoModel() {
		
	}
	
	public CustomerDaoModel(int id, String name, int gender, Date birthDay, String email, String token, String phone,
			String address, Set<CommentProductDaoModel> commentProduct, Set<OrdersDaoModel> orderDao) {
		this.Id = id;
		this.Name = name;
		this.Gender = gender;
		this.BirthDay = birthDay;
		this.Email = email;
		this.Token = token;
		this.Phone = phone;
		this.Address = Address;
		this.commentProduct = commentProduct;
		this.orderDao = orderDao;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return this.Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	
	@Column(name = "name", length = 50, nullable = true)
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
	@Column(name = "gender", length = 1, nullable = true)
	public int getGender() {
		return this.Gender;
	}
	public void setGender(int gender) {
		this.Gender = gender;
	}
	
	@Column(name = "birthday", nullable = true)
	public Date getBirthDay() {
		return this.BirthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.BirthDay = birthDay;
	}
	
	@Column(name = "email", length = 50, nullable = true)
	public String getEmail() {
		return this.Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
	@Column(name = "token", length = 50, nullable = true)
	public String getToken() {
		return this.Token;
	}
	public void setToken(String token) {
		this.Token = token;
	}
	
	@Column(name = "phone", length = 11, nullable = true)
	public String getPhone() {
		return this.Phone;
	}
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	
	@Column(name = "address", nullable = true)
	public String getAddress() {
		return this.Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CommentProductDaoModel> getCommentProduct() {
		return this.commentProduct;
	}
	public void setCommentProduct(Set<CommentProductDaoModel> commentProduct) {
		this.commentProduct = commentProduct;
	}
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<OrdersDaoModel> getOrderDao() {
		return this.orderDao;
	}
	public void setOrderDao(Set<OrdersDaoModel> orderDao) {
		this.orderDao = orderDao;
	}
}
