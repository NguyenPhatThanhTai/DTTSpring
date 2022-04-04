package net.dtt.spring.Models.ViewModels;

import net.dtt.spring.Models.DAOModel.ProductDaoModel;

public class DetailProductViewModel {
	private int Id;
	private String Name;
	private String Description;
	private float Price;
	private String Img_Cover;
	private String Img_Hover;
	private String Img_Detail1;
	private String Img_Detail2;
	private String Img_Detail3;
	private String Img_Detail4;
	private int QuantityInShop;
	private int ProductId;
	private int CategoryId;
	private int ManufactorId;
	
	public DetailProductViewModel() {
		super();
	}

	public DetailProductViewModel(int id, String name, String description, float price, String img_Cover,
			String img_Hover, String img_Detail1, String img_Detail2, String img_Detail3, String img_Detail4,
			int quantityInShop, int productId, int categoryId, int manufactorId) {
		super();
		Id = id;
		Name = name;
		Description = description;
		Price = price;
		Img_Cover = img_Cover;
		Img_Hover = img_Hover;
		Img_Detail1 = img_Detail1;
		Img_Detail2 = img_Detail2;
		Img_Detail3 = img_Detail3;
		Img_Detail4 = img_Detail4;
		QuantityInShop = quantityInShop;
		ProductId = productId;
		CategoryId = categoryId;
		ManufactorId = manufactorId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getImg_Cover() {
		return Img_Cover;
	}

	public void setImg_Cover(String img_Cover) {
		Img_Cover = img_Cover;
	}

	public String getImg_Hover() {
		return Img_Hover;
	}

	public void setImg_Hover(String img_Hover) {
		Img_Hover = img_Hover;
	}

	public String getImg_Detail1() {
		return Img_Detail1;
	}

	public void setImg_Detail1(String img_Detail1) {
		Img_Detail1 = img_Detail1;
	}

	public String getImg_Detail2() {
		return Img_Detail2;
	}

	public void setImg_Detail2(String img_Detail2) {
		Img_Detail2 = img_Detail2;
	}

	public String getImg_Detail3() {
		return Img_Detail3;
	}

	public void setImg_Detail3(String img_Detail3) {
		Img_Detail3 = img_Detail3;
	}

	public String getImg_Detail4() {
		return Img_Detail4;
	}

	public void setImg_Detail4(String img_Detail4) {
		Img_Detail4 = img_Detail4;
	}

	public int getQuantityInShop() {
		return QuantityInShop;
	}

	public void setQuantityInShop(int quantityInShop) {
		QuantityInShop = quantityInShop;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public int getManufactorId() {
		return ManufactorId;
	}

	public void setManufactorId(int manufactorId) {
		ManufactorId = manufactorId;
	}
}
