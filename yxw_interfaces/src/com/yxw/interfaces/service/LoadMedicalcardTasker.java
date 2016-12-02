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
import com.yxw.interfaces.dao.MedicalCardDao;
import com.yxw.interfaces.entity.MedicalCard;

/**
 * 初始化患者信息缓存任务
 * @Package: com.yxw.interfaces.service
 * @ClassName: LoadMedicalcardTasker
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月20日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class LoadMedicalcardTasker implements Callable<List<MedicalCard>> {
	private MedicalCardDao medicalCardDao;
	private static java.util.concurrent.atomic.AtomicLong id = new AtomicLong(0);
	/**
	 * 分页数
	 */
	private int pageNum;
	/**
	 * 分页大小
	 */
	private int pageSize;

	public LoadMedicalcardTasker() {
		super();
	}

	/**
	 * @param pageNum
	 * @param pageSize
	 */
	public LoadMedicalcardTasker(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		medicalCardDao = SpringContextHolder.getBean(MedicalCardDao.class);
	}

	@Override
	public List<MedicalCard> call() throws Exception {
		Page<MedicalCard> page = new Page<MedicalCard>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		PageInfo<MedicalCard> pageInfo = medicalCardDao.findListByPage(null, page);
		List<MedicalCard> medicalCards = pageInfo.getList();
		/*if (!CollectionUtils.isEmpty(medicalCards)) {
			for (MedicalCard medicalCard : medicalCards) {
				System.out.println("medicalCard_" + medicalCard.getPatCardNo() + "_" + medicalCard.getPatCardType());
				FixedCacheManager.put(id.incrementAndGet() + "", id.incrementAndGet());
			}
		}
		return medicalCards.size();
		*/
		return medicalCards;
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
