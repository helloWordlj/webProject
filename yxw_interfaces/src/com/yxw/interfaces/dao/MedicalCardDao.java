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
package com.yxw.interfaces.dao;

import java.util.Map;

import com.yxw.framework.mvc.dao.BaseDao;
import com.yxw.interfaces.entity.MedicalCard;

/**
 * @Package: com.yxw.interfaces.dao
 * @ClassName: MedicalCard
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public interface MedicalCardDao extends BaseDao<MedicalCard, String> {

	/**
	 * 根据参数查询诊疗卡
	 * @param params
	 * @return
	 */
	public abstract MedicalCard findByParams(Map<String, Object> params);

	/**
	 * 添加或更新诊疗卡
	 * @param entity
	 * @param type
	 * @return
	 */
	public abstract String addOrUpdate(MedicalCard entity, String type);
}
