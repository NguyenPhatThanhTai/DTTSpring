package net.dtt.spring.Models.ViewModels;

public class AddToCardRequestModel {
	private int ProductId;
	private int Number;
	private int Action;
	private float Price;
	private String Image;
	private String Name;
	
	public AddToCardRequestModel() {
		super();
	}

	public AddToCardRequestModel(int productId, int number, int action, float price, String image, String name) {
		super();
		ProductId = productId;
		Number = number;
		Action = action;
		Price = price;
		Image = image;
		Name = name;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getAction() {
		return Action;
	}

	public void setAction(int action) {
		Action = action;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
