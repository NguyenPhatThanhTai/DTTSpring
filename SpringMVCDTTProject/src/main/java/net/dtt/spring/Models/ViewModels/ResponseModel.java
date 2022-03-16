package net.dtt.spring.Models.ViewModels;

public class ResponseModel {
	private int ResponseCode;
	private String ResponseMessage;
	private boolean IsSuccess;
	public ResponseModel(int responseCode, String responseMessage, boolean isSuccess) {
		super();
		ResponseCode = responseCode;
		ResponseMessage = responseMessage;
		IsSuccess = isSuccess;
	}
	public int getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}
	public String getResponseMessage() {
		return ResponseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}
	public boolean isIsSuccess() {
		return IsSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		IsSuccess = isSuccess;
	}
	
	
}
