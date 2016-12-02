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
 * 微网站-->医院信息查询请求参数
 * @Package: com.yxw.interfaces.entity.microsite
 * @ClassName: HospitalRequest
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年6月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class HospitalRequest extends Reserve implements Serializable {

	private static final long serialVersionUID = -3476344998849213132L;
	/**
	 * 医院代码,医院没有分院则传入空字符串,医院不存在分院时不允许为空
	 */
	private String branchCode;
	
	public HospitalRequest() {
		super();
	}
	
	public HospitalRequest(String branchCode) {
		super();
		this.branchCode = branchCode;
	}
	
	public String getBranchCode() {
		return branchCode;
	}
	
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
}
