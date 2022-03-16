package net.dtt.spring.Models.ViewModels;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;

public class CommentViewModel {
	private int Id;
	private String Content;
	private Date Time;
	private int Start;
	private String Name;
	private String Ava;
	
	public CommentViewModel() {

	}

	
	
	public CommentViewModel(int id, String content, Date time, int start, String name, String ava) {
		Id = id;
		Content = content;
		Time = time;
		Start = start;
		Name = name;
		Ava = ava;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public int getStart() {
		return Start;
	}

	public void setStart(int start) {
		Start = start;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAva() {
		return Ava;
	}

	public void setAva(String ava) {
		Ava = ava;
	}
}
