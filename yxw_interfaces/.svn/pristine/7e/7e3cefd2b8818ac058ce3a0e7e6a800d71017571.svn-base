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
package com.yxw.interfaces.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.exception.SystemException;
import com.yxw.framework.mvc.dao.impl.BaseDaoImpl;
import com.yxw.interfaces.dao.FriedAndDeliveryDao;
import com.yxw.interfaces.entity.FriedAndDelivery;

/**
 * @Package: com.yxw.interfaces.dao.impl
 * @ClassName: FriedAndDeliveryDaoImpl
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 范建明
 * @Create Date: 2015年11月14日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class FriedAndDeliveryDaoImpl extends
		BaseDaoImpl<FriedAndDelivery, String> implements FriedAndDeliveryDao {
	protected static Logger logger = Logger.getLogger(FriedAndDeliveryDaoImpl.class);
	private final static String SQLNAME_FIND_BY_PARAMS = "findByParams";
	private final static String SQLNAME_FIND_LIST_BY_DELETE = "findListByDelete";

	@Override
	public FriedAndDelivery findByParams(Map<String, Object> params) {
		Assert.notNull(params);
		FriedAndDelivery friedAndDelivery = null;
		try {
			Element element = (Element) FixedCacheManager.get("friedAndDelivery_" + params.get("branchCode") + "_" + 
					params.get("mzFeeId") + "_" + params.get("recipeId"));
			if (element != null) {
				friedAndDelivery = (FriedAndDelivery) element.getObjectValue();
			} else {
				friedAndDelivery = sqlSession.selectOne(getSqlName(SQLNAME_FIND_BY_PARAMS), params);
			}
		} catch (Exception e) {
			logger.error(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
			throw new SystemException(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
		}
		return friedAndDelivery;
	}

	@Override
	public List<FriedAndDelivery> findListByDelete() {
		try {
			return sqlSession.selectList(getSqlName(SQLNAME_FIND_LIST_BY_DELETE));
		} catch (Exception e) {
			logger.error(String.format("查询对象列表出错！语句:%s", getSqlName(SQLNAME_FIND_LIST_BY_DELETE)), e);
			throw new SystemException(String.format("查询对象列表出错！语句:%s", getSqlName(SQLNAME_FIND_LIST_BY_DELETE)), e);
		}
	}

	@Override
	public String addOrUpdate(FriedAndDelivery entity, String type) {
		Assert.notNull(entity);
		try {
			if ("update".equals(type)) {
				super.update(entity);
			} else {
				super.add(entity);
			}
		} catch (Exception e) {
			logger.error(String.format("添加对象出错！语句：%s", getSqlName(type)), e);
			throw new SystemException(String.format("添加对象出错！语句：%s", getSqlName(type)), e);
		}

		return null;
	}
	
}
