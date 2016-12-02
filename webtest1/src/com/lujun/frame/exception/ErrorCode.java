package com.lujun.frame.exception;

public enum ErrorCode {

	Fail("0000","Fail","Fail!"),
	
	Success("1111","Success","Success");
	
	private String code;
	private String message;
	private String description;
	
	private  ErrorCode(String code,String message,String description){
		this.code = code;
		this.message = message;
		this.description = description;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getDescription(){
		return description;
	}
}
