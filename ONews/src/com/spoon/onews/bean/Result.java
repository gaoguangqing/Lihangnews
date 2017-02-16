package com.spoon.onews.bean;

import java.io.Serializable;



public class Result implements Serializable{

	private static final long serialVersionUID = 6577555385975721292L;
	private String requltType;
	private String errorMessage;
	
	
	public String getRequltType() {
		return requltType;
	}
	public void setRequltType(String requltType) {
		this.requltType = requltType;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
