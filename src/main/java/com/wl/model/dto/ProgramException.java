package com.wl.model.dto;

public class ProgramException extends RuntimeException {

	private static final long serialVersionUID = 5569743686046030806L;

	public ProgramException() {
		super();
	}
	public ProgramException(String message,Throwable e) {
		super(message,e);
	}
	public ProgramException(String message) {
		super(message);
	}
}
