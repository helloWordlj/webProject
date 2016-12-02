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
package com.yxw.interfaces.entity;

import java.io.Serializable;

import com.yxw.framework.mvc.entity.BaseEntity;

/**
 * 科室信息
 * @Package: com.yxw.interfaces.entity
 * @ClassName: Department
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class Department extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -53841915646938631L;
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

	public Department() {
		super();
	}

	/**
	 * @param branchCode
	 * @param branchName
	 * @param deptCode
	 * @param deptName
	 * @param deptTelephone
	 * @param deptDescription
	 * @param deptLocation
	 * @param parentDeptCode
	 */
	public Department(String branchCode, String branchName, String deptCode, String deptName, String deptTelephone, String deptDescription,
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

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * @param deptCode the deptCode to set
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the deptTelephone
	 */
	public String getDeptTelephone() {
		return deptTelephone;
	}

	/**
	 * @param deptTelephone the deptTelephone to set
	 */
	public void setDeptTelephone(String deptTelephone) {
		this.deptTelephone = deptTelephone;
	}

	/**
	 * @return the deptDescription
	 */
	public String getDeptDescription() {
		return deptDescription;
	}

	/**
	 * @param deptDescription the deptDescription to set
	 */
	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

	/**
	 * @return the deptLocation
	 */
	public String getDeptLocation() {
		return deptLocation;
	}

	/**
	 * @param deptLocation the deptLocation to set
	 */
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	/**
	 * @return the parentDeptCode
	 */
	public String getParentDeptCode() {
		return parentDeptCode;
	}

	/**
	 * @param parentDeptCode the parentDeptCode to set
	 */
	public void setParentDeptCode(String parentDeptCode) {
		this.parentDeptCode = parentDeptCode;
	}

}
