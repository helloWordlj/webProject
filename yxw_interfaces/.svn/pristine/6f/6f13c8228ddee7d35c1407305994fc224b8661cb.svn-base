/**
 * <html>
 * <body>
 *  <P>  Copyright 2014-2015 www.yx129.com Group.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年11月14日</p>
 *  <p> Created by 范建明</p>
 *  </body>
 * </html>
 */
package com.yxw.interfaces.entity;

import java.io.Serializable;
import java.util.Date;

import com.yxw.framework.mvc.entity.BaseEntity;

/**
 * 代煎配送信息
 * @Package: com.yxw.interfaces.entity
 * @ClassName: FriedAndDelivery
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 范建明
 * @Create Date: 2015年11月14日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class FriedAndDelivery extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6297501587773432307L;

	/**
	 * 医院代码,医院没有分院，则值为空字符串；医院有分院，则值不允许为空字符串
	 */
	private String branchCode;
	/**
	 * 缴费项唯一标识,门诊流水号，就诊登记号等，并非处方号,用来唯一标识一笔缴费(包含1..n个处方或检查单)
	 */
	private String mzFeeId;
	/**
	 * 处方单ID[检查单ID、检验单ID、治疗单ID等]
	 */
	private String recipeId;
	/**
	 * 是否代煎
	 * @see com.yxw.interfaces.constants.FriedType
	 */
	private String fried;
	/**
	 * 是否配送
	 * @see com.yxw.interfaces.constants.DeliveryType
	 */
	private String delivered;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县区
	 */
	private String county;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 邮政编码
	 */
	private String postcode;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 联系人手机
	 */
	private String mobile;
	/**
	 * 联系人固话
	 */
	private String telephone;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public FriedAndDelivery() {
		super();
	}

	public FriedAndDelivery(String branchCode, String mzFeeId, String recipeId,
			String fried, String delivered, String province, String city,
			String county, String address, String postcode, String contacts,
			String mobile, String telephone, Date createTime) {
		super();
		this.branchCode = branchCode;
		this.mzFeeId = mzFeeId;
		this.recipeId = recipeId;
		this.fried = fried;
		this.delivered = delivered;
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.postcode = postcode;
		this.contacts = contacts;
		this.mobile = mobile;
		this.telephone = telephone;
		this.createTime = createTime;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getMzFeeId() {
		return mzFeeId;
	}

	public void setMzFeeId(String mzFeeId) {
		this.mzFeeId = mzFeeId;
	}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public String getFried() {
		return fried;
	}

	public void setFried(String fried) {
		this.fried = fried;
	}

	public String getDelivered() {
		return delivered;
	}

	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
