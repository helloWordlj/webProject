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

import java.util.Map;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.exception.SystemException;
import com.yxw.framework.mvc.dao.impl.BaseDaoImpl;
import com.yxw.interfaces.dao.MedicalCardDao;
import com.yxw.interfaces.entity.MedicalCard;

/**
 * 诊疗卡dao实现
 * @Package: com.yxw.interfaces.dao.impl
 * @ClassName: MedicalCardDaoImpl
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class MedicalCardDaoImpl extends BaseDaoImpl<MedicalCard, String> implements MedicalCardDao {
	protected static Logger logger = Logger.getLogger(MedicalCardDaoImpl.class);
	private static final String SQLNAME_FIND_BY_PARAMS = "findByParams";

	@Override
	public MedicalCard findByParams(Map<String, Object> params) {
		Assert.notNull(params);
		MedicalCard medicalCard = null;
		try {
			boolean status = FixedCacheManager.containsKey("medicalCard_" + params.get("patCardNo") + "_" + params.get("patCardType"));
			if (status) {
				Element element = (Element) FixedCacheManager.get("medicalCard_" + params.get("patCardNo") + "_" + params.get("patCardType"));
				medicalCard = (MedicalCard) element.getObjectValue();
			}
			if (medicalCard == null) {
				medicalCard = sqlSession.selectOne(getSqlName(SQLNAME_FIND_BY_PARAMS), params);
			}
		} catch (Exception e) {
			logger.error(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
			throw new SystemException(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
		}
		return medicalCard;
	}

	@Override
	public String addOrUpdate(MedicalCard entity, String type) {
		Assert.notNull(entity);
		try {
			if ("update".equals(type)) {
				super.update(entity);
			} else {
				super.add(entity);
			}
		} catch (Exception e) {
			logger.error(String.format("添加对象出错！语句：%s", getSqlName("add")), e);
			throw new SystemException(String.format("添加对象出错！语句：%s", getSqlName("add")), e);
		}

		return null;
	}

}
