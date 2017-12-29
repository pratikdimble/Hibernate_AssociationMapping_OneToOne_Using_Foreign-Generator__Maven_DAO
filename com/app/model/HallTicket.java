package com.app.model;


public class HallTicket {
	
	private int ticketId;
	private String exam;
	private Student stud;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	@Override
	public String toString() {
		return "HallTicket [ticketId=" + ticketId + ", exam=" + exam +"]";
	}

	
	
	
}
