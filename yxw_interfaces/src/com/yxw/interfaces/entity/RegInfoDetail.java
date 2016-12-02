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
 * 号源明细信息
 * @Package: com.yxw.interfaces.entity
 * @ClassName: RegInfoDetail
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class RegInfoDetail extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4339261953282273982L;
	/**
	 * 号源日期
	 */
	private String regDate;
	/**
	 * 分院代码
	 */
	private String branchCode;
	/**
	 * 科室代码
	 */
	private String deptCode;
	/**
	 * 医生代码
	 */
	private String doctorCode;
	/**
	 * 时段,见TimeType
	 * @see com.yxw.interfaces.constants.TimeType
	 */
	private String timeFlag;
	/**
	 * 是否有分时,0:无分时,1:有分时
	 */
	private String hasDetailTime;
	/**
	 * 开始时间,格式：HH24:MI
	 */
	private String beginTime;
	/**
	 * 结束时间,格式：HH24:MI
	 */
	private String endTime;
	/**
	 * 出诊状态,1:出诊,2:停诊
	 */
	private String workStatus;
	/**
	 * 号源总数
	 */
	private String totalNum;
	/**
	 * 剩余可预约号源数
	 */
	private String leftNum;
	/**
	 * 挂号费,单位:分
	 */
	private String regFee;
	/**
	 * 诊疗费,单位:分
	 */
	private String treatFee;
	/**
	 * 排班ID
	 */
	private String workId;

	public RegInfoDetail() {
		super();
	}

	/**
	 * @param regDate
	 * @param branchCode
	 * @param deptCode
	 * @param doctorCode
	 * @param timeFlag
	 * @param hasDetailTime
	 * @param beginTime
	 * @param endTime
	 * @param workStatus
	 * @param totalNum
	 * @param leftNum
	 * @param regFee
	 * @param treatFee
	 * @param workId
	 */
	public RegInfoDetail(String regDate, String branchCode, String deptCode, String doctorCode, String timeFlag, String hasDetailTime,
			String beginTime, String endTime, String workStatus, String totalNum, String leftNum, String regFee, String treatFee, String workId) {
		super();
		this.regDate = regDate;
		this.branchCode = branchCode;
		this.deptCode = deptCode;
		this.doctorCode = doctorCode;
		this.timeFlag = timeFlag;
		this.hasDetailTime = hasDetailTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.workStatus = workStatus;
		this.totalNum = totalNum;
		this.leftNum = leftNum;
		this.regFee = regFee;
		this.treatFee = treatFee;
		this.workId = workId;
	}

	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the doctorCode
	 */
	public String getDoctorCode() {
		return doctorCode;
	}

	/**
	 * @param doctorCode the doctorCode to set
	 */
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	/**
	 * @return the timeFlag
	 */
	public String getTimeFlag() {
		return timeFlag;
	}

	/**
	 * @param timeFlag the timeFlag to set
	 */
	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	/**
	 * @return the hasDetailTime
	 */
	public String getHasDetailTime() {
		return hasDetailTime;
	}

	/**
	 * @param hasDetailTime the hasDetailTime to set
	 */
	public void setHasDetailTime(String hasDetailTime) {
		this.hasDetailTime = hasDetailTime;
	}

	/**
	 * @return the beginTime
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the workStatus
	 */
	public String getWorkStatus() {
		return workStatus;
	}

	/**
	 * @param workStatus the workStatus to set
	 */
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	/**
	 * @return the totalNum
	 */
	public String getTotalNum() {
		return totalNum;
	}

	/**
	 * @param totalNum the totalNum to set
	 */
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	/**
	 * @return the leftNum
	 */
	public String getLeftNum() {
		return leftNum;
	}

	/**
	 * @param leftNum the leftNum to set
	 */
	public void setLeftNum(String leftNum) {
		this.leftNum = leftNum;
	}

	/**
	 * @return the regFee
	 */
	public String getRegFee() {
		return regFee;
	}

	/**
	 * @param regFee the regFee to set
	 */
	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

	/**
	 * @return the treatFee
	 */
	public String getTreatFee() {
		return treatFee;
	}

	/**
	 * @param treatFee the treatFee to set
	 */
	public void setTreatFee(String treatFee) {
		this.treatFee = treatFee;
	}

	/**
	 * @return the workId
	 */
	public String getWorkId() {
		return workId;
	}

	/**
	 * @param workId the workId to set
	 */
	public void setWorkId(String workId) {
		this.workId = workId;
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

}
