package com.jal.wholesales.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorsList {
private List<String> common = null;
	
	private Map<String, String> errorsByParameter = null;
	
	public ErrorsList() {
		common = new ArrayList<String>();
		errorsByParameter = new HashMap<String, String>();
	}
	
	public void addCommonError(String e) {
		common.add(e);
	}
	
	public List<String> getCommonErrors() {
		return this.common;
	}
	
	public void addParameterError(String parameterName, String error) {
		this.errorsByParameter.put(parameterName, error);
	}
	
	
	public String getParameterError(String parameterName) {
		return this.errorsByParameter.get(parameterName);
	}
	
	public boolean hasErrors() {
		return this.common.size()>0 || this.errorsByParameter.size()>0;
	}
}
