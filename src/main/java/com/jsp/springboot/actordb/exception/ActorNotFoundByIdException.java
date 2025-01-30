package com.jsp.springboot.actordb.exception;

public class ActorNotFoundByIdException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public ActorNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	
	
}
