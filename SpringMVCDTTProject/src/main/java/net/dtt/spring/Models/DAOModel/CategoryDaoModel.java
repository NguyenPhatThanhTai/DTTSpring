package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;
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
@Table(name = "category")
public class CategoryDaoModel implements Serializable {
	private int Id;
	private String Name;
	private int Status;
	private Set<ProductDaoModel> Product = new HashSet<ProductDaoModel>();

	public CategoryDaoModel() {
	}


	public CategoryDaoModel(int id, String name) {
		this.Id = id;
		this.Name = name;
	}
	
	public CategoryDaoModel(int id, String name, int status, Set<ProductDaoModel> product) {
		Id = id;
		Name = name;
		Product = product;
		Status = status;
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
	
	@Column(name = "status", length = 1, nullable = false)
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<ProductDaoModel> getProduct() {
        return this.Product;
    }

    public void setProduct(Set<ProductDaoModel> product) {
        this.Product = product;
    }
}
