package com.lujun.frame.exception;

public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	private String description;
	
	public BaseException(String code,String message,String description){
		this.code = code;
		this.message = message;
		this.description = description;
	}
	
	public BaseException(String code,String message){
		this.code = code;
		this.message = message;
	}

	public BaseException() {
        super();
    }
	
	public BaseException(Throwable e){
		super(e);
	}
	
	public BaseException(String message) {
        super(message);
    }
	
	public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
	
	protected BaseException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	
}
