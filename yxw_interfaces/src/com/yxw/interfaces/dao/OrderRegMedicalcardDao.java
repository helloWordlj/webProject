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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yxw.framework.mvc.dao.BaseDao;
import com.yxw.interfaces.entity.OrderRegMedicalcard;

/**
 * @Package: com.yxw.interfaces.dao
 * @ClassName: OrderRegMedicalcardDao
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月16日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public interface OrderRegMedicalcardDao extends BaseDao<OrderRegMedicalcard, String> {
	/**
	 * 根据参数查询挂号诊疗信息
	 * @param params
	 * @return
	 */
	public abstract OrderRegMedicalcard findByParams(Map<String, Object> params);

	/**
	 * 查询待删除的记录总数
	 * @return
	 */
	public Long countByDelete();

	/**
	 * 分页查询待删除的挂号诊疗信息
	 * @param params
	 * @param page
	 * @return
	 */
	public PageInfo<OrderRegMedicalcard> findListByPageDelete(Map<String, Object> params, Page<OrderRegMedicalcard> page);

}
