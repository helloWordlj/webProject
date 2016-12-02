/**
 * <html>
 * <body>
 *  <P>  Copyright 2014-2015 www.yx129.com Group.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年4月28日</p>
 *  <p> Created by 申午武</p>
 *  </body>
 * </html>
 */
package com.yxw.interfaces.vo.microsite;

import java.io.Serializable;

import com.yxw.interfaces.vo.Reserve;

/**
 * 微网站-->科室列表查询请求参数
 * @Package: com.yxw.interfaces.entity.microsite
 * @ClassName: DeptRequest
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年6月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class DeptRequest extends Reserve implements Serializable {

	private static final long serialVersionUID = 8662732712446814561L;
	/**
	 * 医院代码,医院没有分院则传入空字符串,医院不存在分院时不允许为空
	 */
	private String branchCode;
	/**
	 * 父科室代码
	 */
	private String parentDeptCode;
	
	public DeptRequest() {
		super();
	}

	public DeptRequest(String branchCode, String parentDeptCode) {
		super();
		this.branchCode = branchCode;
		this.parentDeptCode = parentDeptCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getParentDeptCode() {
		return parentDeptCode;
	}

	public void setParentDeptCode(String parentDeptCode) {
		this.parentDeptCode = parentDeptCode;
	}

}
