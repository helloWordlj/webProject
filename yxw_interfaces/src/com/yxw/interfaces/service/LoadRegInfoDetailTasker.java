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
package com.yxw.interfaces.service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yxw.framework.common.spring.ext.SpringContextHolder;
import com.yxw.interfaces.dao.RegInfoDetailDao;
import com.yxw.interfaces.entity.RegInfoDetail;

/**
 * @Package: com.yxw.interfaces.service
 * @ClassName: LoadRegInfoDetailTasker
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月31日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class LoadRegInfoDetailTasker implements Callable<List<RegInfoDetail>> {
	private RegInfoDetailDao regInfoDetailDao;
	private static java.util.concurrent.atomic.AtomicLong id = new AtomicLong(0);
	/**
	 * 分页数
	 */
	private int pageNum;
	/**
	 * 分页大小
	 */
	private int pageSize;

	public LoadRegInfoDetailTasker() {
		super();
	}

	/**
	 * @param pageNum
	 * @param pageSize
	 */
	public LoadRegInfoDetailTasker(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		regInfoDetailDao = SpringContextHolder.getBean(RegInfoDetailDao.class);
	}

	@Override
	public List<RegInfoDetail> call() throws Exception {
		Page<RegInfoDetail> page = new Page<RegInfoDetail>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		PageInfo<RegInfoDetail> pageInfo = regInfoDetailDao.findListByPage(null, page);
		List<RegInfoDetail> regInfoDetails = pageInfo.getList();
		return regInfoDetails;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
