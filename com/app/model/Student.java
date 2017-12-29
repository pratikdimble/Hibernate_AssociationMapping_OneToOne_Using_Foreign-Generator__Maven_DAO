package com.app.model;


public class Student {

	private int studId;
	private String studName;
	private HallTicket hall;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public HallTicket getHall() {
		return hall;
	}
	public void setHall(HallTicket hall) {
		this.hall = hall;
	}
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName +  "]";
	}
	
	
	
	
}
