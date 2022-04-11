package net.dtt.spring.Models.ViewModels;

public class AddCategoryRequestModel {
	private int Id;
	private String Name;

	public AddCategoryRequestModel() {
		super();
	}

	public AddCategoryRequestModel(String name, int id) {
		super();
		Id = id;
		Name = name;
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
}
