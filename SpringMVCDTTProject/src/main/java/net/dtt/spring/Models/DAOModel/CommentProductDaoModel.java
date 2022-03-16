package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.protobuf.Timestamp;

@Entity
@Table(name = "comment_product")
public class CommentProductDaoModel implements Serializable {
	private int Id;
	private String Content;
	private Date Time;
	private int Start;
	private ProductDaoModel product;
	private CustomerDaoModel customer;
	
	public CommentProductDaoModel() {
		
	}
	
	public CommentProductDaoModel(int id, String content, Date time, int start, ProductDaoModel product,
			CustomerDaoModel customer) {
		this.Id = id;
		this.Content = content;
		this.Time = time;
		this.Start = start;
		this.product = product;
		this.customer = customer;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return this.Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	
	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.Content;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	
	@Column(name = "time", nullable = false)
	public Date getTime() {
		return this.Time;
	}
	public void setTime(Date time) {
		this.Time = time;
	}
	
	@Column(name = "star", length = 11, nullable = false)
	public int getStart() {
		return this.Start;
	}
	public void setStart(int start) {
		this.Start = start;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
	public ProductDaoModel getProduct() {
		return this.product;
	}
	public void setProduct(ProductDaoModel product) {
		this.product = product;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
	public CustomerDaoModel getCustomer() {
		return this.customer;
	}
	public void setCustomer(CustomerDaoModel customer) {
		this.customer = customer;
	}
}
