package net.dtt.spring.Models.ViewModels;

public class AddManufactorRequestModel {
	private int Id;
	private String Name;

	public AddManufactorRequestModel() {
		super();
	}

	public AddManufactorRequestModel(String name, int id) {
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
