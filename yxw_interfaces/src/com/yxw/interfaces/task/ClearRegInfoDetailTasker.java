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
package com.yxw.interfaces.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.common.spring.ext.SpringContextHolder;
import com.yxw.interfaces.dao.RegInfoDetailDao;
import com.yxw.interfaces.entity.RegInfoDetail;

/**
 * 定时清理过期的号源信息
 * @Package: com.yxw.interfaces.task
 * @ClassName: ClearOrderRegMedicalcard
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月20日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class ClearRegInfoDetailTasker {
	protected static Logger logger = Logger.getLogger(ClearRegInfoDetailTasker.class);
	private RegInfoDetailDao regInfoDetailDao = SpringContextHolder.getBean(RegInfoDetailDao.class);
	/**
	 * 计数器
	 */
	private final AtomicLong counter = new AtomicLong();

	public void clearRegInfoDetail() {
		long executionTimes = counter.incrementAndGet();
		if (logger.isInfoEnabled()) {
			logger.info("第 " + executionTimes + " 次过期号源信息清理开始....................");
		}
		//分页计算
		int count = regInfoDetailDao.countByDelete().intValue();
		int pageNum = 0;
		int lastSize = 0;
		int pageSize = 1000;
		if (count % pageSize != 0) {
			pageNum = count / pageSize + 1;
			lastSize = count % pageSize;
		} else {
			pageNum = count / pageSize;
		}

		if (logger.isInfoEnabled()) {
			logger.info("过期号源信息共计" + count + "条....................");
		}
		for (int i = 0; i < pageNum; i++) {
			//起始,结束位置计算
			int beginIndex = i * pageSize;
			int endIndex = 0;
			if (lastSize > 0 && i + 1 >= pageNum) {
				endIndex = beginIndex + lastSize;
			} else {
				endIndex = beginIndex + pageSize;
			}
			Page<RegInfoDetail> page = new Page<RegInfoDetail>();
			page.setPageNum(beginIndex);
			page.setPageSize(endIndex);
			PageInfo<RegInfoDetail> pageInfo = regInfoDetailDao.findListByPageDelete(null, page);
			List<RegInfoDetail> regInfoDetails = pageInfo.getList();
			if (regInfoDetails.size() > 0) {
				List<String> ids = new ArrayList<String>();
				Map<String, String> keys = new HashMap<String, String>();
				for (RegInfoDetail regInfoDetail : regInfoDetails) {
					ids.add(regInfoDetail.getId());
					String key =
							"regInfoDetails_" + regInfoDetail.getRegDate() + "_" + regInfoDetail.getBranchCode() + "_" + regInfoDetail.getDeptCode();
					keys.put(key, key);
				}
				if (ids.size() > 0) {
					regInfoDetailDao.batchDelete(ids);
				}

				if (keys.size() > 0) {
					for (Map.Entry<String, String> entry : keys.entrySet()) {
						boolean status = FixedCacheManager.containsKey(entry.getKey());
						if (status) {
							FixedCacheManager.remove(entry.getKey());
						} else {
							logger.error("缓存异常:method=clearRegInfoDetail,key=" + entry.getKey());
						}
					}
				}
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("第 " + executionTimes + " 次过期号源信息清理结束....................");
		}
	}
}
