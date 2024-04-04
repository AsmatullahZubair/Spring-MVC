package com.solutions.a3z.errors;

import java.sql.Timestamp;

public class EmployeeErrorResponse {
	
	private String status;
	private String message;
	private Timestamp timeStamp;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = new Timestamp(timeStamp);
	}
	
	

}
