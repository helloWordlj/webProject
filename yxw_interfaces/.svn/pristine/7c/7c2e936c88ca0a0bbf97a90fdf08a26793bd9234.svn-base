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
 * 微网站-->科室列表
 * @Package: com.yxw.interfaces.entity.microsite
 * @ClassName: Dept
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年6月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class Dept extends Reserve implements Serializable {

	private static final long serialVersionUID = 1264647313562211695L;
	/**
	 * 医院代码,医院没有分院则返回空字符串
	 */
	private String branchCode;
	/**
	 * 医院名称,医院没有分院则返回空字符串
	 */
	private String branchName;
	/**
	 * 科室代码
	 */
	private String deptCode;
	/**
	 * 科室名称
	 */
	private String deptName;
	/**
	 * 科室电话
	 */
	private String deptTelephone;
	/**
	 * 科室介绍
	 */
	private String deptDescription;
	/**
	 * 科室位置描述
	 */
	private String deptLocation;
	/**
	 * 父科室代码,0表示没有父科室
	 */
	private String parentDeptCode;
	
	public Dept() {
		super();
	}

	public Dept(String branchCode, String branchName, String deptCode,
			String deptName, String deptTelephone, String deptDescription,
			String deptLocation, String parentDeptCode) {
		super();
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptTelephone = deptTelephone;
		this.deptDescription = deptDescription;
		this.deptLocation = deptLocation;
		this.parentDeptCode = parentDeptCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptTelephone() {
		return deptTelephone;
	}

	public void setDeptTelephone(String deptTelephone) {
		this.deptTelephone = deptTelephone;
	}

	public String getDeptDescription() {
		return deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	public String getParentDeptCode() {
		return parentDeptCode;
	}

	public void setParentDeptCode(String parentDeptCode) {
		this.parentDeptCode = parentDeptCode;
	}
	
}
