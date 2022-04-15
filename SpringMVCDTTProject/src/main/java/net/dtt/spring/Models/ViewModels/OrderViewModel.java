package net.dtt.spring.Models.ViewModels;

import java.util.List;

import net.dtt.spring.Models.DAOModel.DetailOrdersDaoModel;

public class OrderViewModel {
	private int OrderId;
	private String Name;
	private String Phone;
	private String Address;
	private String Note;
	private String Totalrice;
	private int Status;
	private List<DetailOrderViewModel> ListOrder;
	
	public OrderViewModel() {
		super();
	}

	public OrderViewModel(int orderId, String name, String phone, String address, String note, String totalrice,
			int status, List<DetailOrderViewModel> listOrder) {
		super();
		OrderId = orderId;
		Name = name;
		Phone = phone;
		Address = address;
		Note = note;
		Totalrice = totalrice;
		Status = status;
		ListOrder = listOrder;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getTotalrice() {
		return Totalrice;
	}

	public void setTotalrice(String totalrice) {
		Totalrice = totalrice;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public List<DetailOrderViewModel> getListOrder() {
		return ListOrder;
	}

	public void setListOrder(List<DetailOrderViewModel> listOrder) {
		ListOrder = listOrder;
	}
}