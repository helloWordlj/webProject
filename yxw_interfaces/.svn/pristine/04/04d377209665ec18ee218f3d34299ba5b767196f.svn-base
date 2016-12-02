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
package com.yxw.interfaces.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.exception.SystemException;
import com.yxw.framework.mvc.dao.impl.BaseDaoImpl;
import com.yxw.interfaces.dao.OrderRegMedicalcardDao;
import com.yxw.interfaces.entity.OrderRegMedicalcard;

/**
 * @Package: com.yxw.interfaces.dao.impl
 * @ClassName: OrderRegMedicalcardDaoImpl
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月16日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class OrderRegMedicalcardDaoImpl extends BaseDaoImpl<OrderRegMedicalcard, String> implements OrderRegMedicalcardDao {
	protected static Logger logger = Logger.getLogger(OrderRegMedicalcardDaoImpl.class);
	private final static String SQLNAME_FIND_BY_PARAMS = "findByParams";
	private final static String SQLNAME_ADD = "add";
	private final static String SQLNAME_COUNT_BY_DELETE = "countByDelete";
	private final static String SQLNAME_FIND_LIST_BY_PAGE_DELETE = "findListByPageDelete";

	@Override
	public OrderRegMedicalcard findByParams(Map<String, Object> params) {
		Assert.notNull(params);
		OrderRegMedicalcard orderRegMedicalcard = null;
		try {
			boolean status = FixedCacheManager.containsKey("orderRegMedicalcards");
			if (status) {
				Element element = (Element) FixedCacheManager.get("orderRegMedicalcards");
				Map<String, OrderRegMedicalcard> orderRegMedicalcards = (Map<String, OrderRegMedicalcard>) element.getObjectValue();
				orderRegMedicalcard = orderRegMedicalcards.get(params.get("lockId"));
			}
			if (orderRegMedicalcard == null) {
				orderRegMedicalcard = sqlSession.selectOne(getSqlName(SQLNAME_FIND_BY_PARAMS), params);
			}
		} catch (Exception e) {
			logger.error(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
			throw new SystemException(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
		}
		return orderRegMedicalcard;
	}

	@Override
	public String add(OrderRegMedicalcard entity) {
		try {
			Assert.notNull(entity);
			sqlSession.insert(getSqlName(SQLNAME_ADD), entity);
			return entity.getId();
		} catch (Exception e) {
			logger.error(String.format("保存对象出错！语句：%s", getSqlName(SQLNAME_ADD)), e);
			throw new SystemException(String.format("保存对象出错！语句：%s", getSqlName(SQLNAME_ADD)), e);
		}
	}

	@Override
	public Long countByDelete() {
		try {
			return sqlSession.selectOne(getSqlName(SQLNAME_COUNT_BY_DELETE));
		} catch (Exception e) {
			logger.error(String.format("查询对象总记录数出错！语句：%s", getSqlName(SQLNAME_COUNT_BY_DELETE)), e);
			throw new SystemException(String.format("查询对象总记录数出错！语句：%s", getSqlName(SQLNAME_COUNT_BY_DELETE)), e);
		}
	}

	@Override
	public PageInfo<OrderRegMedicalcard> findListByPageDelete(Map<String, Object> params, Page<OrderRegMedicalcard> page) {
		try {
			// List<T> list =
			// sqlSession.selectList(getSqlName(SQLNAME_FIND_LIST_BY_PAGE),
			// parms,
			// new RowBounds(page.getPageNum(), page.getPageSize()));
			PageHelper.startPage(page.getPageNum(), page.getPageSize());
			List<OrderRegMedicalcard> list = sqlSession.selectList(getSqlName(SQLNAME_FIND_LIST_BY_PAGE_DELETE), params);
			return new PageInfo<OrderRegMedicalcard>(list);
		} catch (Exception e) {
			logger.error(String.format("根据分页对象查询列表出错！语句:%s", getSqlName(SQLNAME_FIND_LIST_BY_PAGE_DELETE)), e);
			throw new SystemException(String.format("根据分页对象查询列表出错！语句:%s", getSqlName(SQLNAME_FIND_LIST_BY_PAGE_DELETE)), e);
		}
	}

}
