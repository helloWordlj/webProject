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
import com.yxw.interfaces.entity.Department;

/**
 * 科室dao接口
 * @Package: com.yxw.interfaces.dao
 * @ClassName: DepartmentDao
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月2日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public interface DepartmentDao extends BaseDao<Department, String> {
	/**
	 * 根据参数查询科室
	 * @param params
	 * @return
	 */
	public abstract Department findByParams(Map<String, Object> params);

}
