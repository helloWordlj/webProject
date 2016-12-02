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
package com.yxw.interfaces.dao;

import java.util.List;
import java.util.Map;

import com.yxw.framework.mvc.dao.BaseDao;
import com.yxw.interfaces.entity.FriedAndDelivery;

/**
 * 代煎配送dao接口
 * @Package: com.yxw.interfaces.dao
 * @ClassName: FriedAndDeliveryDao
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 范建明
 * @Create Date: 2015年11月14日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public interface FriedAndDeliveryDao extends BaseDao<FriedAndDelivery, String> {
	
	/**
	 * 根据参数查询代煎配送
	 * @param params
	 * @return
	 */
	public abstract FriedAndDelivery findByParams(Map<String, Object> params);
	
	/**
	 * 查询待删除的代煎配送信息
	 * @param params
	 * @param page
	 * @return
	 */
	public List<FriedAndDelivery> findListByDelete();
	
	/**
	 * 添加或更新代煎配送信息
	 * @param entity
	 * @param type
	 * @return
	 */
	public abstract String addOrUpdate(FriedAndDelivery entity, String type);
	
}
