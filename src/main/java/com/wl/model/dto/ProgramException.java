package com.wl.model.dto;

/**
 * 异常类
 * @author wuli
 * @date 2019年12月26日下午2:54:59
 */
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
