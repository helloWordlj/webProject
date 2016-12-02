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
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.common.spring.ext.SpringContextHolder;
import com.yxw.interfaces.dao.OrderRegMedicalcardDao;
import com.yxw.interfaces.entity.OrderRegMedicalcard;

/**
 * 定时清理超时的挂号诊疗信息
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
public class ClearOrderRegMedicalcardTasker {
	protected static Logger logger = Logger.getLogger(ClearOrderRegMedicalcardTasker.class);
	private OrderRegMedicalcardDao orderRegMedicalcardDao = SpringContextHolder.getBean(OrderRegMedicalcardDao.class);
	/**
	 * 计数器
	 */
	private final AtomicLong counter = new AtomicLong();

	public void clearOrderRegMedicalcard() {
		long executionTimes = counter.incrementAndGet();
		if (logger.isInfoEnabled()) {
			logger.info("第 " + executionTimes + " 次超时挂号诊疗信息清理开始....................");
		}
		//分页计算
		int count = orderRegMedicalcardDao.countByDelete().intValue();
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
			logger.info("挂号诊疗信息超时记录共计" + count + "条....................");
		}

		List<String> lockIds = new ArrayList<String>();
		for (int i = 0; i < pageNum; i++) {
			//起始,结束位置计算
			int beginIndex = i * pageSize;
			int endIndex = 0;
			if (lastSize > 0 && i + 1 >= pageNum) {
				endIndex = beginIndex + lastSize;
			} else {
				endIndex = beginIndex + pageSize;
			}
			Page<OrderRegMedicalcard> page = new Page<OrderRegMedicalcard>();
			page.setPageNum(beginIndex);
			page.setPageSize(endIndex);
			PageInfo<OrderRegMedicalcard> pageInfo = orderRegMedicalcardDao.findListByPageDelete(null, page);
			List<OrderRegMedicalcard> orderRegMedicalcards = pageInfo.getList();
			if (orderRegMedicalcards.size() > 0) {
				List<String> ids = new ArrayList<String>();
				for (OrderRegMedicalcard orderRegMedicalcard : orderRegMedicalcards) {
					ids.add(orderRegMedicalcard.getId());
					lockIds.add(orderRegMedicalcard.getLockId());

				}
				if (ids.size() > 0) {
					orderRegMedicalcardDao.batchDelete(ids);
				}

			}
		}

		//清除缓存
		if (lockIds.size() > 0) {
			boolean status = FixedCacheManager.containsKey("orderRegMedicalcards");
			if (status) {
				net.sf.ehcache.Element element = (net.sf.ehcache.Element) FixedCacheManager.get("orderRegMedicalcards");
				Map<String, OrderRegMedicalcard> orderRegMedicalcardMap = (Map<String, OrderRegMedicalcard>) element.getObjectValue();
				for (String lockId : lockIds) {
					OrderRegMedicalcard orderRegMedicalcard = orderRegMedicalcardMap.get(lockId);
					if (orderRegMedicalcard != null) {
						orderRegMedicalcardMap.remove(lockId);
					} else {
						logger.error("缓存异常:method=clearOrderRegMedicalcard,lockId=" + lockId);
					}
				}
				FixedCacheManager.put("orderRegMedicalcards", orderRegMedicalcardMap);
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("第 " + executionTimes + " 次超时挂号诊疗信息清理结束....................");
		}
	}
}
