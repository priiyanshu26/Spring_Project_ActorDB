package com.jsp.springboot.actordb.utility;

public class ResponseStructure<F> {
	private int statuscode;
	private String message;
	private F actor;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public F getActor() {
		return actor;
	}
	public void setActor(F actor) {
		this.actor = actor;
	}


}
