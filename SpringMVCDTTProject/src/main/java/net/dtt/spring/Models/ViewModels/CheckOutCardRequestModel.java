package net.dtt.spring.Models.ViewModels;

import java.sql.Date;
import java.util.List;

import net.dtt.spring.Models.DAOModel.CustomerDaoModel;

public class CheckOutCardRequestModel {
	public List<Integer> Quantity;
	public List<Integer> ProductId;
	private String NameReceive;
	private String PhoneReceive;
	private String AddressReceive;
	private String Note;
	private String Status;
	private String TotalPrice;
	private String CustomerId;
	private String District;
	private String City;
	
	
	
	public CheckOutCardRequestModel() {
		super();
	}



	public CheckOutCardRequestModel(List<Integer> quantity, List<Integer> productId, String nameReceive,
			String phoneReceive, String addressReceive, String note, String status, String totalPrice,
			String customerId, String district, String city) {
		super();
		Quantity = quantity;
		ProductId = productId;
		NameReceive = nameReceive;
		PhoneReceive = phoneReceive;
		AddressReceive = addressReceive;
		Note = note;
		Status = status;
		TotalPrice = totalPrice;
		CustomerId = customerId;
		District = district;
		City = city;
	}



	public List<Integer> getQuantity() {
		return Quantity;
	}



	public void setQuantity(List<Integer> quantity) {
		Quantity = quantity;
	}



	public List<Integer> getProductId() {
		return ProductId;
	}



	public void setProductId(List<Integer> productId) {
		ProductId = productId;
	}



	public String getNameReceive() {
		return NameReceive;
	}



	public void setNameReceive(String nameReceive) {
		NameReceive = nameReceive;
	}



	public String getPhoneReceive() {
		return PhoneReceive;
	}



	public void setPhoneReceive(String phoneReceive) {
		PhoneReceive = phoneReceive;
	}



	public String getAddressReceive() {
		return AddressReceive;
	}



	public void setAddressReceive(String addressReceive) {
		AddressReceive = addressReceive;
	}



	public String getNote() {
		return Note;
	}



	public void setNote(String note) {
		Note = note;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public String getTotalPrice() {
		return TotalPrice;
	}



	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}



	public String getCustomerId() {
		return CustomerId;
	}



	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}



	public String getDistrict() {
		return District;
	}



	public void setDistrict(String district) {
		District = district;
	}



	public String getCity() {
		return City;
	}



	public void setCity(String city) {
		City = city;
	}
	
	
	
}
