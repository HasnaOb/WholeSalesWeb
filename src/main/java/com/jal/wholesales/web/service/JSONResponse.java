package com.jal.wholesales.web.service;

public class JSONResponse {
	  
	private Object data = null;	
	private String errorCode = null;

	
	public JSONResponse() {
		
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	

}
