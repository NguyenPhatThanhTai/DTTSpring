package net.dtt.spring.Models.ViewModels;

public class CategoryViewModel {
	private int Id;
	private String Name;
	
	public CategoryViewModel() {
		super();
	}
	
	public CategoryViewModel(int id, String name) {
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
