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
import com.yxw.interfaces.entity.RegisterDoctor;

/**
 * 可挂号医生dao接口
 * @Package: com.yxw.interfaces.dao
 * @ClassName: RegisterDoctorDao
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public interface RegisterDoctorDao extends BaseDao<RegisterDoctor, String> {
	/**
	 * 根据参数查询可挂号医生
	 * @param params
	 * @return
	 */
	public abstract RegisterDoctor findByParams(Map<String, Object> params);
}
