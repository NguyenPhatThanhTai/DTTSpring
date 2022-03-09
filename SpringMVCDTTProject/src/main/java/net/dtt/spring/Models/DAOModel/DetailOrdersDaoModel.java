package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_orders")
public class DetailOrdersDaoModel implements Serializable {
	private OrdersDaoModel order;
	private ProductDaoModel product;
	private int Quantity;
	private String Size;
	
	public DetailOrdersDaoModel() {
		
	}
	public DetailOrdersDaoModel(OrdersDaoModel order, ProductDaoModel product, int quantity, String size) {
		order = order;
		product = product;
		Quantity = quantity;
		Size = size;
	}
	
	@Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id", nullable = false)
	public OrdersDaoModel getOrder() {
		return order;
	}
	public void setOrder(OrdersDaoModel order) {
		order = order;
	}
	
	@Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
	public ProductDaoModel getProduct() {
		return product;
	}
	public void setProduct(ProductDaoModel product) {
		product = product;
	}
	
	@Column(name = "quantity", length = 11, nullable = true)
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	@Column(name = "size", length = 11, nullable = true)
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	
	
}
