package com.lujun.webtest1.exception;

public enum ErrorCode {

	SUCCESS("0000", "操作成功！"), PARAM_NULL("0001", "请求参数为空！"), FAIL("0002",
			"操作失败！"), NO_PERMISSION("0003", "没有权限！"), NO_DATA("0004", "没有数据！");

	private String errCode;
	private String errMsg;

	ErrorCode(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
