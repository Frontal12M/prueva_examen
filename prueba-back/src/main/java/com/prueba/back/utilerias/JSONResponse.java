package com.prueba.back.utilerias;

public class JSONResponse {

	private String responseString;
	private Object responseObject;
	private boolean responseBoolean;

	public JSONResponse() {
		super();
	}

	public JSONResponse(String responseString, Object responseObject, boolean responseBoolean) {
		super();
		this.responseString = responseString;
		this.responseObject = responseObject;
		this.responseBoolean = responseBoolean;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	public boolean isResponseBoolean() {
		return responseBoolean;
	}

	public void setResponseBoolean(boolean responseBoolean) {
		this.responseBoolean = responseBoolean;
	}

	@Override
	public String toString() {
		return "JSONResponse [responseString=" + responseString + ", responseObject=" + responseObject
				+ ", responseBoolean=" + responseBoolean + "]";
	}

}
