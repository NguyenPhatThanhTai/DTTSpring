package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetailDaoModel implements Serializable {
	private int Id;
	private String Name;
	private String Description;
	private Float Price;
	private String Img_Cover;
	private String Img_Hover;
	private String Img_Detail1;
	private String Img_Detail2;
	private String Img_Detail3;
	private String Img_Detail4;
	private int QuantityInShop;
	private ProductDaoModel product;
	
	public ProductDetailDaoModel() {
		
	}
	
	public ProductDetailDaoModel(int id, String name, String description, Float price, String img_Cover,
			String img_Hover, String img_Detail1, String img_Detail2, String img_Detail3, String img_Detail4,
			int quantityInShop, ProductDaoModel product) {
		this.Id = id;
		this.Name = name;
		this.Description = description;
		this.Price = price;
		this.Img_Cover = img_Cover;
		this.Img_Hover = img_Hover;
		this.Img_Detail1 = img_Detail1;
		this.Img_Detail2 = img_Detail2;
		this.Img_Detail3 = img_Detail3;
		this.Img_Detail4 = img_Detail4;
		this.QuantityInShop = quantityInShop;
		this.product = product;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Column(name = "name", length = 50, nullable = true)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name = "description", nullable = true)
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@Column(name = "price", length = 11, nullable = true)
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	
	@Column(name = "img_cover", nullable = true)
	public String getImg_Cover() {
		return Img_Cover;
	}
	public void setImg_Cover(String img_Cover) {
		Img_Cover = img_Cover;
	}
	
	@Column(name = "img_hover", nullable = true)
	public String getImg_Hover() {
		return Img_Hover;
	}
	public void setImg_Hover(String img_Hover) {
		Img_Hover = img_Hover;
	}
	
	@Column(name = "img_detail1", nullable = true)
	public String getImg_Detail1() {
		return Img_Detail1;
	}
	public void setImg_Detail1(String img_Detail1) {
		Img_Detail1 = img_Detail1;
	}
	
	@Column(name = "img_detail2", nullable = true)
	public String getImg_Detail2() {
		return Img_Detail2;
	}
	public void setImg_Detail2(String img_Detail2) {
		Img_Detail2 = img_Detail2;
	}
	
	@Column(name = "img_detail3", nullable = true)
	public String getImg_Detail3() {
		return Img_Detail3;
	}
	public void setImg_Detail3(String img_Detail3) {
		Img_Detail3 = img_Detail3;
	}
	
	@Column(name = "img_detail4", nullable = true)
	public String getImg_Detail4() {
		return Img_Detail4;
	}
	public void setImg_Detail4(String img_Detail4) {
		Img_Detail4 = img_Detail4;
	}
	
	@Column(name = "quantity_in_shop", nullable = true)
	public int getQuantityInShop() {
		return QuantityInShop;
	}
	public void setQuantityInShop(int quantityInShop) {
		QuantityInShop = quantityInShop;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = true)
	public ProductDaoModel getProduct() {
		return this.product;
	}
	public void setProduct(ProductDaoModel product) {
		this.product = product;
	}
}
