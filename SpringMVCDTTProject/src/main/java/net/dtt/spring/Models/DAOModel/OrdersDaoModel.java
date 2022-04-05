package net.dtt.spring.Models.DAOModel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;

import net.dtt.spring.entity.Two;

@Entity
@Table(name = "orders")
public class OrdersDaoModel implements Serializable {
	private int Id;
	private Date Time;
	private String NameReceive;
	private String PhoneReceive;
	private String AddressReceive;
	private String Note;
	private int Status;
	private float TotalPrice;
	private CustomerDaoModel Customer;
	private Set<DetailOrdersDaoModel> DetailOrder = new HashSet<DetailOrdersDaoModel>();
	
	public OrdersDaoModel() {
		
	}
	
	public OrdersDaoModel(int id, Date time, String nameReceive, String phoneReceive, String addressReceive,
			String note, int status, float totalPrice, CustomerDaoModel customer, Set<DetailOrdersDaoModel> detailOrder) {
		Id = id;
		Time = time;
		NameReceive = nameReceive;
		PhoneReceive = phoneReceive;
		AddressReceive = addressReceive;
		Note = note;
		Status = status;
		TotalPrice = totalPrice;
		Customer = customer;
		DetailOrder = detailOrder;
	}
	
	@Id
	@Column(name = "id", length = 11, nullable = false)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Column(name = "time", nullable = true)
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	
	@Column(name = "name_receive", length = 50, nullable = true)
	public String getNameReceive() {
		return NameReceive;
	}
	public void setNameReceive(String nameReceive) {
		NameReceive = nameReceive;
	}
	
	@Column(name = "phone_receive", length = 11, nullable = true)
	public String getPhoneReceive() {
		return PhoneReceive;
	}
	public void setPhoneReceive(String phoneReceive) {
		PhoneReceive = phoneReceive;
	}
	
	@Column(name = "address_receive", nullable = true)
	public String getAddressReceive() {
		return AddressReceive;
	}
	public void setAddressReceive(String addressReceive) {
		AddressReceive = addressReceive;
	}
	
	@Column(name = "note", nullable = true)
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	
	@Column(name = "status", length = 11, nullable = true)
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	@Column(name = "total_price", nullable = true)
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
	public CustomerDaoModel getCustomer() {
		return Customer;
	}
	public void setCustomer(CustomerDaoModel customer) {
		Customer = customer;
	}
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<DetailOrdersDaoModel> getDetailOrder() {
        return this.DetailOrder;
    }

    public void setDetailOrder(Set<DetailOrdersDaoModel> detailOrder) {
        this.DetailOrder = detailOrder;
    }
}
