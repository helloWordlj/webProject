package com.lujun.webtest1.exception;

public class TestException extends Exception {

	private static final long serialVersionUID = 7881624942536785655L;

	private String errCode;

	public TestException(String errCode, String message) {
		super(message);
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
