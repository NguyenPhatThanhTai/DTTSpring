package net.dtt.spring.Models.ViewModels;

public class AddProductRequestModel {
	public String Name;
	public String Descripsion;
	public String Price;
	public String Img_cover;
	public String Img_hover;
	public String Img_detail1;
	public String Img_detail2;
	public String Img_detail3;
	public String Img_detail4;
	public String CategoryId;
	public String ManufactorsId;
	
	public AddProductRequestModel() {
		
	}

	public AddProductRequestModel(String name, String descripsion, String price, String img_cover, String img_hover,
			String img_detail1, String img_detail2, String img_detail3, String img_detail4, String categoryId,
			String manufactorsId) {
		Name = name;
		Descripsion = descripsion;
		Price = price;
		Img_cover = img_cover;
		Img_hover = img_hover;
		Img_detail1 = img_detail1;
		Img_detail2 = img_detail2;
		Img_detail3 = img_detail3;
		Img_detail4 = img_detail4;
		CategoryId = categoryId;
		ManufactorsId = manufactorsId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescripsion() {
		return Descripsion;
	}

	public void setDescripsion(String descripsion) {
		Descripsion = descripsion;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getImg_cover() {
		return Img_cover;
	}

	public void setImg_cover(String img_cover) {
		Img_cover = img_cover;
	}

	public String getImg_hover() {
		return Img_hover;
	}

	public void setImg_hover(String img_hover) {
		Img_hover = img_hover;
	}

	public String getImg_detail1() {
		return Img_detail1;
	}

	public void setImg_detail1(String img_detail1) {
		Img_detail1 = img_detail1;
	}

	public String getImg_detail2() {
		return Img_detail2;
	}

	public void setImg_detail2(String img_detail2) {
		Img_detail2 = img_detail2;
	}

	public String getImg_detail3() {
		return Img_detail3;
	}

	public void setImg_detail3(String img_detail3) {
		Img_detail3 = img_detail3;
	}

	public String getImg_detail4() {
		return Img_detail4;
	}

	public void setImg_detail4(String img_detail4) {
		Img_detail4 = img_detail4;
	}

	public String getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}

	public String getManufactorsId() {
		return ManufactorsId;
	}

	public void setManufactorsId(String manufactorsId) {
		ManufactorsId = manufactorsId;
	}
}
