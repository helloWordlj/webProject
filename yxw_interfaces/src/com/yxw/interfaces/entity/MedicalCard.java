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
 * 诊疗卡信息
 * @Package: com.yxw.interfaces.entity
 * @ClassName: MedicalCard
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class MedicalCard extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4145746507357710437L;
	/**
	 * 患者唯一标识
	 */
	private String patId;
	/**
	 * 患者类型,见PatientType
	 * @see com.yxw.interfaces.constants.PatientType
	 */
	private String patType;
	/**
	 * 姓名
	 */
	private String patName;
	/**
	 * 诊疗卡类型,见CardType
	 * @see com.yxw.interfaces.constants.CardType
	 */
	private String patCardType;
	/**
	 * 诊疗卡号码
	 */
	private String patCardNo;
	/**
	 * 证件类型,见IdType,患者类型为儿童时，该项允许为空
	 * @see com.yxw.interfaces.constants.IdType
	 */
	private String patIdType;
	/**
	 * 证件号码,患者类型为“2”儿童时，该项允许为空
	 */
	private String patIdNo;
	/**
	 * 性别,见GenderType
	 * @see com.yxw.interfaces.constants.GenderType
	 */
	private String patSex;
	/**
	 * 出生日期
	 */
	private String patBirth;
	/**
	 * 地址
	 */
	private String patAddress;
	/**
	 * 电话
	 */
	private String patMobile;
	/**
	 * 联系人姓名,患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回
	 */
	private String guardName;
	/**
	 * 联系人证件类型, 患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回
	 */
	private String guardIdType;
	/**
	 * 联系人证件号码,患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回
	 */
	private String guardIdNo;
	/**
	 * 联系人电话
	 */
	private String guardMobile;
	/**
	 * 联系人地址
	 */
	private String guardAddress;

	public MedicalCard() {
		super();
	}

	/**
	 * @param patId
	 * @param patType
	 * @param patName
	 * @param patSex
	 * @param patBirth
	 * @param patAddress
	 * @param patMobile
	 * @param patCardType
	 * @param patCardNo
	 * @param patIdType
	 * @param patIdNo
	 * @param guardName
	 * @param guardIdType
	 * @param guardIdNo
	 * @param guardMobile
	 * @param guardAddress
	 */
	public MedicalCard(String patId, String patType, String patName, String patSex, String patBirth, String patAddress, String patMobile,
			String patCardType, String patCardNo, String patIdType, String patIdNo, String guardName, String guardIdType, String guardIdNo,
			String guardMobile, String guardAddress) {
		super();
		this.patId = patId;
		this.patType = patType;
		this.patName = patName;
		this.patSex = patSex;
		this.patBirth = patBirth;
		this.patAddress = patAddress;
		this.patMobile = patMobile;
		this.patCardType = patCardType;
		this.patCardNo = patCardNo;
		this.patIdType = patIdType;
		this.patIdNo = patIdNo;
		this.guardName = guardName;
		this.guardIdType = guardIdType;
		this.guardIdNo = guardIdNo;
		this.guardMobile = guardMobile;
		this.guardAddress = guardAddress;
	}

	/**
	 * @return the patId
	 */
	public String getPatId() {
		return patId;
	}

	/**
	 * @param patId the patId to set
	 */
	public void setPatId(String patId) {
		this.patId = patId;
	}

	/**
	 * @return the patType
	 */
	public String getPatType() {
		return patType;
	}

	/**
	 * @param patType the patType to set
	 */
	public void setPatType(String patType) {
		this.patType = patType;
	}

	/**
	 * @return the patName
	 */
	public String getPatName() {
		return patName;
	}

	/**
	 * @param patName the patName to set
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}

	/**
	 * @return the patSex
	 */
	public String getPatSex() {
		return patSex;
	}

	/**
	 * @param patSex the patSex to set
	 */
	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	/**
	 * @return the patBirth
	 */
	public String getPatBirth() {
		return patBirth;
	}

	/**
	 * @param patBirth the patBirth to set
	 */
	public void setPatBirth(String patBirth) {
		this.patBirth = patBirth;
	}

	/**
	 * @return the patAddress
	 */
	public String getPatAddress() {
		return patAddress;
	}

	/**
	 * @param patAddress the patAddress to set
	 */
	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	/**
	 * @return the patMobile
	 */
	public String getPatMobile() {
		return patMobile;
	}

	/**
	 * @param patMobile the patMobile to set
	 */
	public void setPatMobile(String patMobile) {
		this.patMobile = patMobile;
	}

	/**
	 * @return the patCardType
	 */
	public String getPatCardType() {
		return patCardType;
	}

	/**
	 * @param patCardType the patCardType to set
	 */
	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	/**
	 * @return the patCardNo
	 */
	public String getPatCardNo() {
		return patCardNo;
	}

	/**
	 * @param patCardNo the patCardNo to set
	 */
	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	/**
	 * @return the patIdType
	 */
	public String getPatIdType() {
		return patIdType;
	}

	/**
	 * @param patIdType the patIdType to set
	 */
	public void setPatIdType(String patIdType) {
		this.patIdType = patIdType;
	}

	/**
	 * @return the patIdNo
	 */
	public String getPatIdNo() {
		return patIdNo;
	}

	/**
	 * @param patIdNo the patIdNo to set
	 */
	public void setPatIdNo(String patIdNo) {
		this.patIdNo = patIdNo;
	}

	/**
	 * @return the guardName
	 */
	public String getGuardName() {
		return guardName;
	}

	/**
	 * @param guardName the guardName to set
	 */
	public void setGuardName(String guardName) {
		this.guardName = guardName;
	}

	/**
	 * @return the guardIdType
	 */
	public String getGuardIdType() {
		return guardIdType;
	}

	/**
	 * @param guardIdType the guardIdType to set
	 */
	public void setGuardIdType(String guardIdType) {
		this.guardIdType = guardIdType;
	}

	/**
	 * @return the guardIdNo
	 */
	public String getGuardIdNo() {
		return guardIdNo;
	}

	/**
	 * @param guardIdNo the guardIdNo to set
	 */
	public void setGuardIdNo(String guardIdNo) {
		this.guardIdNo = guardIdNo;
	}

	/**
	 * @return the guardMobile
	 */
	public String getGuardMobile() {
		return guardMobile;
	}

	/**
	 * @param guardMobile the guardMobile to set
	 */
	public void setGuardMobile(String guardMobile) {
		this.guardMobile = guardMobile;
	}

	/**
	 * @return the guardAddress
	 */
	public String getGuardAddress() {
		return guardAddress;
	}

	/**
	 * @param guardAddress the guardAddress to set
	 */
	public void setGuardAddress(String guardAddress) {
		this.guardAddress = guardAddress;
	}

}
