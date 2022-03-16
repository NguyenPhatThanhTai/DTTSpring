package net.dtt.spring.Models.ViewModels;

import java.sql.Date;

public class SendCommentRequestModel {
	private String ProdId;
	private String Content;
	private String Start;
	
	public SendCommentRequestModel() {
		
	}
	
	public SendCommentRequestModel(String prodId, String content, String start) {
		super();
		ProdId = prodId;
		Content = content;
		Start = start;
	}
	
	public String getProdId() {
		return ProdId;
	}
	public void setProdId(String prodId) {
		ProdId = prodId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getStart() {
		return Start;
	}
	public void setStart(String start) {
		Start = start;
	}
	
	
}
