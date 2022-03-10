package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductDaoModel implements Serializable {
	private int Id;
	private ProductDetailDaoModel productDetail;
	private ManufacturersDaoModel manufacturers;
	private CategoryDaoModel category;
	private Set<CommentProductDaoModel> commentProduct = new HashSet<CommentProductDaoModel>();
	private Set<DetailOrdersDaoModel> detailOrder = new HashSet<DetailOrdersDaoModel>();
	
	public ProductDaoModel() {
		
	}
	
	public ProductDaoModel(int id, ProductDetailDaoModel productDetailDaoModel, ManufacturersDaoModel manufacturers, CategoryDaoModel category, 
			Set<CommentProductDaoModel> commentProduct
			, Set<DetailOrdersDaoModel> detailOrder) {
		this.Id = id;
		this.productDetail = productDetailDaoModel;
		this.manufacturers = manufacturers;
		this.category = category;
		this.commentProduct = commentProduct;
		this.detailOrder = detailOrder;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return this.Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturers_id", nullable = true)
	public ManufacturersDaoModel getManufacturers() {
		return this.manufacturers;
	}
	public void setManufacturers(ManufacturersDaoModel manufacturers) {
		this.manufacturers = manufacturers;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = true)
	public CategoryDaoModel getCategory() {
		return this.category;
	}
	public void setCategory(CategoryDaoModel category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CommentProductDaoModel> getCommentProduct() {
		return this.commentProduct;
	}
	public void setCommentProduct(Set<CommentProductDaoModel> commentProduct) {
		this.commentProduct = commentProduct;
	}
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<DetailOrdersDaoModel> getDetailOrder() {
        return this.detailOrder;
    }

    public void setDetailOrder(Set<DetailOrdersDaoModel> detailOrder) {
        this.detailOrder = detailOrder;
    }
    
    @OneToOne(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public ProductDetailDaoModel getProductDetail() {
        return this.productDetail;
    }

    public void setProductDetail(ProductDetailDaoModel productDetailDaoModel) {
        this.productDetail = productDetailDaoModel;
    }
}
