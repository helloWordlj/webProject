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

import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.exception.SystemException;
import com.yxw.framework.mvc.dao.impl.BaseDaoImpl;
import com.yxw.interfaces.dao.RegisterDoctorDao;
import com.yxw.interfaces.entity.RegisterDoctor;

/**
 * @Package: com.yxw.interfaces.dao.impl
 * @ClassName: RegisterDoctorDaoImpl
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class RegisterDoctorDaoImpl extends BaseDaoImpl<RegisterDoctor, String> implements RegisterDoctorDao {

	protected static Logger logger = Logger.getLogger(RegisterDoctorDaoImpl.class);
	private static final String SQLNAME_FIND_BY_PARAMS = "findByParams";
	private static final String SQLNAME_BATCH_INSERT = "batchInsert";

	@Override
	public RegisterDoctor findByParams(Map<String, Object> params) {
		Assert.notNull(params);
		RegisterDoctor registerDoctor = null;
		try {
			boolean status = FixedCacheManager.containsKey("registerDoctors");
			if (status) {
				Element element = (Element) FixedCacheManager.get("registerDoctors");
				Map<String, RegisterDoctor> registerDoctors = (Map<String, RegisterDoctor>) element.getObjectValue();
				String key = String.valueOf(params.get("deptCode")) + "_" + params.get("doctorCode");
				registerDoctor = registerDoctors.get(key);
			}
			if (registerDoctor == null) {
				registerDoctor = sqlSession.selectOne(getSqlName(SQLNAME_FIND_BY_PARAMS), params);
			}
		} catch (Exception e) {
			logger.error(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
			throw new SystemException(String.format("查询对象出错！语句：%s", getSqlName(SQLNAME_FIND_BY_PARAMS)), e);
		}
		return registerDoctor;
	}

	@Override
	public void batchInsert(List<RegisterDoctor> registerDoctors) {
		Assert.notNull(registerDoctors);
		SqlSession session = sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		try {
			int num = 0;
			int lastSize = 0;
			int total = registerDoctors.size();
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
				List<RegisterDoctor> child = registerDoctors.subList(beginIndex, endIndex);
				session.insert(getSqlName(SQLNAME_BATCH_INSERT), child);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(String.format("批量插入数据出错！语句：%s", getSqlName(SQLNAME_BATCH_INSERT)), e);
			throw new SystemException(String.format("批量插入数据出错！语句：%s", getSqlName(SQLNAME_BATCH_INSERT)), e);
		}
	}

}
