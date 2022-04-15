package net.dtt.spring.Models.ViewModels;

public class DetailOrderViewModel {
	private int ProductId;
	private String ProductName;
	private int ProductQuantity;
	
	public DetailOrderViewModel() {
		super();
	}

	public DetailOrderViewModel(int productId, String productName, int productQuantity) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductQuantity = productQuantity;
	}
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
}
