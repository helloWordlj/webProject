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
package com.yxw.interfaces.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.common.spring.ext.SpringContextHolder;
import com.yxw.interfaces.dao.FriedAndDeliveryDao;
import com.yxw.interfaces.entity.FriedAndDelivery;

/**
 * 定时清理超时的代煎配送信息
 * @Package: com.yxw.interfaces.task
 * @ClassName: ClearFriedAndDeliveryTasker
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 范建明
 * @Create Date: 2015年11月14日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class ClearFriedAndDeliveryTasker {
	protected static Logger logger = Logger.getLogger(ClearFriedAndDeliveryTasker.class);
	private FriedAndDeliveryDao friedAndDeliveryDao = SpringContextHolder.getBean(FriedAndDeliveryDao.class);
	/**
	 * 计数器
	 */
	private final AtomicLong counter = new AtomicLong();
	
	public void clearFriedAndDelivery() {
		long executionTimes = counter.incrementAndGet();
		if (logger.isInfoEnabled()) {
			logger.info("第 " + executionTimes + " 次超时代煎配送信息清理开始....................");
		}
		
		List<FriedAndDelivery> friedAndDeliverys = friedAndDeliveryDao.findListByDelete();
		
		if (logger.isInfoEnabled()) {
			logger.info("代煎配送信息超时记录共计" + friedAndDeliverys.size() + "条....................");
		}
		
		if (friedAndDeliverys.size() > 0) {
			List<String> ids = new ArrayList<String>();
			// 清除缓存
			for (FriedAndDelivery friedAndDelivery : friedAndDeliverys) {
				ids.add(friedAndDelivery.getId());
				FixedCacheManager.remove("friedAndDelivery_" + friedAndDelivery.getBranchCode() + "_" + 
						friedAndDelivery.getMzFeeId() + "_" + friedAndDelivery.getRecipeId());
			}
			// 清除数据库
			friedAndDeliveryDao.batchDelete(ids);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("第 " + executionTimes + " 次超时代煎配送信息清理结束....................");
		}
	}

}
