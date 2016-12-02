/**
 * <html>
 * <body>
 *  <P>  Copyright(C)版权所有 - 2015 广州医享网络科技发展有限公司.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年3月3日</p>
 *  <p> Created by Administrator</p>
 *  </body>
 * </html>
 */
package com.yxw.framework.common.cache;

import java.io.Serializable;
import java.util.List;

/**
 * 缓存基类
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年3月3日
 */
public interface Cache extends Serializable {
	/**
	 * 缓存对象
	 * 
	 * @param key
	 * @param value
	 */
	public abstract void put(String key, Object value);

	/**
	 * 保存有有效期的数据
	 * 
	 * @param key
	 * @param value
	 * @param 数据超时的秒数
	 * @return
	 */
	public abstract void put(String key, Object value, int TTL);

	/**
	 * 是否存在某个key
	 * 
	 * @param key
	 * @return
	 */
	public abstract boolean containsKey(String key);

	/**
	 * 从缓存中获取对象
	 * 
	 * @param key
	 * @return
	 */
	public abstract Object get(String key);

	/**
	 * 删除缓存
	 * 
	 * @param key
	 */
	public abstract void remove(String key);

	/**
	 * 删除所有缓存
	 */
	public abstract void removeAll();

	/**
	 * 获取所有的keys
	 * 
	 * @return
	 */
	public abstract List getKeys();

	/**
	 * 获取缓存对象的数量
	 * 
	 * @return
	 */
	public abstract int getSize();

	/**
	 * 获取缓存名称
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * 获取缓存对象大小
	 * 
	 * @return
	 */
	public abstract long getSizeInBytes();

	/**
	 * 刷新缓存
	 */
	public abstract void flush();
}
