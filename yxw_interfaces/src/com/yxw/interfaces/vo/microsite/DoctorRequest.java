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
 * 微网站-->医生列表查询请求参数
 * @Package: com.yxw.interfaces.entity.microsite
 * @ClassName: DoctorRequest
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年6月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class DoctorRequest extends Reserve implements Serializable {

	private static final long serialVersionUID = -1558175877204802095L;
	/**
	 * 医院代码,医院没有分院则传入空字符串,医院不存在分院时不允许为空
	 */
	private String branchCode;
	/**
	 * 科室代码,如果为空则医生代码必须为空,返回所有医生的信息
	 */
	private String deptCode;
	/**
	 * 医生代码,如果为空则获取某科室下所有医生的信息
	 */
	private String doctorCode;
	
	public DoctorRequest() {
		super();
	}

	public DoctorRequest(String branchCode, String deptCode, String doctorCode) {
		super();
		this.branchCode = branchCode;
		this.deptCode = deptCode;
		this.doctorCode = doctorCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	
}
