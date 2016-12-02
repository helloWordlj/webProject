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

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.exception.SystemException;
import com.yxw.framework.mvc.dao.impl.BaseDaoImpl;
import com.yxw.interfaces.dao.RegInfoDetailDao;
import com.yxw.interfaces.entity.RegInfoDetail;

/**
 * @Package: com.yxw.interfaces.dao.impl
 * @ClassName: RegInfoDetailDaoImpl
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class RegInfoDetailDaoImpl extends BaseDaoImpl<RegInfoDetail, String> implements RegInfoDetailDao {
	protected static Logger logger = Logger.getLogger(RegInfoDetailDaoImpl.class);
	private static final String SQLNAME_FIND_BY_PARAMS = "findByParams";
	private static final String SQLNAME_BATCH_INSERT = "batchInsert";
	private static final String SQLNAME_DELETE_BY_PARAMS = "deleteByParams";
	private final static String SQLNAME_COUNT_BY_DELETE = "countByDelete";
	private final static String SQLNAME_FIND_LIST_BY_PAGE_DELETE = "findListByPageDelete";
	private static final String SQLNAME_BATCH_DELETE = "batchDelete";

	@Override
	public RegInfoDetail findByParams(Map<String, Object> params) {
		Assert.notNull(params);
		RegInfoDetail regInfoDetail = null;
		try {
			String key = "regInfoDetails_" + params.get("regDate") + "_" + params.get("branchCode") + "_" + params.get("deptCode");
			boolean status = FixedCacheManager.containsKey(key);
			if (status) {
				Element element = (Element) FixedCacheManager.get(key);
				Map<String, RegInfoDetail> regInfoDetails = (Map<String, RegInfoDetail>) element.getObjectValue();
				String childKey = params.get("regDate") + "_" + params.get("doctorCode") + "_" + params.get("timeFlag");
				regInfoDetail = (RegInfoDetail) regInfoDetails.get(childKey);
			}
			if (regInfoDetail == null) {
				regInfoDetail = sqlSession.selectOne(getSqlName(SQLNAME_FIND_BY_PARAMS), params);
			}
		} catch (Exception e) {
			logger.error(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
			throw new SystemException(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
		}
		return regInfoDetail;
	}

	@Override
	public void batchInsert(List<RegInfoDetail> regInfoDetails) {
		Assert.notNull(regInfoDetails);
		SqlSession session = sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		try {
			int num = 0;
			int lastSize = 0;
			int total = regInfoDetails.size();
			int size = 1000;
			if (total % size != 0) {
				num = total / size + 1;
				lastSize = total % size;
			} else {
				num = total / size;
			}
			for (int i = 0; i < num; i++) {
				int beginIndex = i * size;
				int endIndex = 0;
				if (lastSize > 0 && i + 1 >= num) {
					endIndex = beginIndex + lastSize;
				} else {
					endIndex = beginIndex + size;
				}
				List<RegInfoDetail> child = regInfoDetails.subList(beginIndex, endIndex);
				session.insert(getSqlName(SQLNAME_BATCH_INSERT), child);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(String.format("批量插入数据出错！语句：%s", getSqlName(SQLNAME_BATCH_INSERT)), e);
			throw new SystemException(String.format("批量插入数据出错！语句：%s", getSqlName(SQLNAME_BATCH_INSERT)), e);
		}
	}

	public void deleteByParams(Map<String, Object> params) {
		Assert.notNull(params);
		try {
			sqlSession.delete(getSqlName(SQLNAME_DELETE_BY_PARAMS), params);
		} catch (Exception e) {
			logger.error(String.format("删除对象出错！语句：%s", getSqlName(SQLNAME_DELETE_BY_PARAMS)), e);
			throw new SystemException(String.format("删除对象出错！语句：%s", getSqlName(SQLNAME_DELETE_BY_PARAMS)), e);
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
	public PageInfo<RegInfoDetail> findListByPageDelete(Map<String, Object> params, Page<RegInfoDetail> page) {
		try {
			// List<T> list =
			// sqlSession.selectList(getSqlName(SQLNAME_FIND_LIST_BY_PAGE),
			// parms,
			// new RowBounds(page.getPageNum(), page.getPageSize()));
			PageHelper.startPage(page.getPageNum(), page.getPageSize());
			List<RegInfoDetail> list = sqlSession.selectList(getSqlName(SQLNAME_FIND_LIST_BY_PAGE_DELETE), params);
			return new PageInfo<RegInfoDetail>(list);
		} catch (Exception e) {
			logger.error(String.format("根据分页对象查询列表出错！语句:%s", getSqlName(SQLNAME_FIND_LIST_BY_PAGE_DELETE)), e);
			throw new SystemException(String.format("根据分页对象查询列表出错！语句:%s", getSqlName(SQLNAME_FIND_LIST_BY_PAGE_DELETE)), e);
		}
	}

	@Override
	public void batchDelete(List<String> ids) {
		SqlSession session = sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		try {
			Assert.notNull(ids);
			session.delete(getSqlName(SQLNAME_BATCH_DELETE), ids);
			session.commit();
		} catch (Exception e) {
			logger.error(String.format("批量删除对象出错！语句：%s", getSqlName(SQLNAME_BATCH_DELETE)), e);
			throw new SystemException(String.format("批量删除对象出错！语句：%s", getSqlName(SQLNAME_BATCH_DELETE)), e);
		}
	}

}
