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
package com.yxw.framework.common.cache.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yxw.framework.common.cache.Cache;
import com.yxw.framework.common.cache.CacheConfig;
import com.yxw.framework.common.cache.CacheFactory;
import com.yxw.framework.common.spring.ext.SpringContextHolder;

/**
 * 即时缓存管理类
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年3月3日
 */
public class InstantCacheManager {
	private static Logger logger = Logger.getLogger(InstantCacheManager.class);
	private static Cache instantCache = CacheFactory.getCache("instantCache");
	private static CacheConfig config = (CacheConfig) SpringContextHolder.getBean("cacheConfig");
	/**
	 * 数据超时的秒数
	 */
	private static final int liveTime = 300;
	/**
	 * 是否停用
	 */
	private static boolean isStop = false;

	static {
		if (config != null) {
			isStop = config.isInstantCacheStop();
		}
	}

	public synchronized static boolean isStop() {
		return isStop;
	}

	public synchronized static void setStop(boolean isStop) {
		InstantCacheManager.isStop = isStop;
	}

	/**
	 * 缓存对象,默认300秒缓存时间
	 * 
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value) {
		if (!isStop()) {
			logger.debug(new StringBuffer("cache object to instantCache... key：").append(key));
			instantCache.put(key, value, liveTime);
		}
	}

	/**
	 * 缓存对象
	 * 
	 * @param key
	 * @param value
	 * @param TTL
	 */
	public static void put(String key, Object value, int TTL) {
		if (!isStop()) {
			logger.debug(new StringBuffer("cache object to instantCache... key：").append(key));
			instantCache.put(key, value, TTL);
		}
	}

	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		if (isStop()) {
			return null;
		}
		logger.debug(new StringBuffer("get object from instantCache... key：").append(key));
		return instantCache.get(key);
	}

	public static <T> T getObjectValue(String key) {
		Object obj = get(key);
		if (obj == null)
			return null;

		net.sf.ehcache.Element element = (net.sf.ehcache.Element) obj;
		return (T) element.getObjectValue();
	}

	/**
	 * 检查是否存在某个key
	 * 
	 * @param key
	 * @return
	 */
	public static boolean containsKey(String key) {
		return instantCache.containsKey(key);
	}

	/**
	 * 删除缓存
	 * 
	 * @param key
	 */
	public static void remove(String key) {
		logger.debug(new StringBuffer("remove object from instantCache... key：").append(key));
		instantCache.remove(key);
	}

	/**
	 * 删除所有缓存
	 */
	public static void removeAll() {
		logger.debug("remove all object from instantCache");
		instantCache.removeAll();
	}

	/**
	 * 根据类型删除缓存
	 * 
	 * @param _class
	 */
	public static void removeCacheByClass(Class _class) {
		List list = getKeys();
		for (int i = 0; i < list.size(); i++) {
			String cacheKey = String.valueOf(list.get(i));
			if (cacheKey.startsWith("instantCache_" + _class.getName())) {
				remove(cacheKey);
			}
		}
	}

	/**
	 * 获取所有的keys
	 * 
	 * @return
	 */
	public static List getKeys() {
		return instantCache.getKeys();
	}

	/**
	 * 获取缓存对象的数量
	 * 
	 * @return
	 */
	public static int getSize() {
		return instantCache.getSize();
	}

	/**
	 * 刷新缓存
	 */
	public static void flush() {
		instantCache.flush();
	}

	/**
	 * 获取缓存名称
	 * 
	 * @return
	 */
	public static String getCacheName() {
		return instantCache.getName();
	}

	/**
	 * 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
	 * 缓存名_+包名+类名+方法名+参数，如fixCache_com.yxw.wechat.service.impl.serviceImpl
	 * .queryUser.User.2c9289d21664d139011664d2a78f0001.0
	 */
	// public static String getCacheKey(Class _class, String methodName,
	// Object... arguments) {
	// StringBuffer sb = new StringBuffer("instantCache_");
	// sb.append(_class.getName()).append(".").append(methodName);
	// if ((arguments != null) && (arguments.length != 0)) {
	// for (int i = 0; i < arguments.length; i++) {
	// sb.append(".").append(arguments[i]);
	// }
	// }
	// return sb.toString();
	// }
}
