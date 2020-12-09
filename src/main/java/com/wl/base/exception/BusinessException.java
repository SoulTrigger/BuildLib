package com.wl.base.exception;

/**
 * 业务异常
 * 
 * @author wuli
 * @date 2020年5月12日下午12:10:50
 */
@SuppressWarnings("serial")
public class BusinessException extends Exception {

	public BusinessException(Throwable e) {
		super(e);
	}

	public BusinessException(String msg, Throwable e) {
		super(msg, e);
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException() {
	}

}
