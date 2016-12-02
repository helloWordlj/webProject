package com.lujun.frame.exception;

public class SystemException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(ErrorCode fail){
		super();
	}
	
	public SystemException(String code,String message,String description){
		super.setCode(code);
		super.setMessage(message);
		super.setDescription(description);
	}
}
