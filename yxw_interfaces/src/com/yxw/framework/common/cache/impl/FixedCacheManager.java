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
 * 固定缓存管理类
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年3月3日
 */
public class FixedCacheManager {
	private static Logger logger = Logger.getLogger(FixedCacheManager.class);
	private static Cache fixedCache = CacheFactory.getCache("fixedCache");
	private static CacheConfig config = (CacheConfig) SpringContextHolder.getBean("cacheConfig");;
	/**
	 * 是否停用
	 */
	private static boolean isStop = false;

	static {
		if (config != null) {
			isStop = config.isFixedCacheStop();
		}
	}

	public synchronized static boolean isStop() {
		return isStop;
	}

	public synchronized static void setStop(boolean isStop) {
		FixedCacheManager.isStop = isStop;
	}

	/**
	 * 缓存对象
	 * 
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value) {
		if (!isStop()) {
			logger.debug(new StringBuffer("cache object to fixedCache... key：").append(key));
			fixedCache.put(key, value);
		}
	}

	/**
	 * 缓存对象
	 * 
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value, int TTL) {
		if (!isStop()) {
			logger.debug(new StringBuffer("cache object to fixedCache... key：").append(key));
			fixedCache.put(key, value, TTL);
		}
	}

	/**
	 * 从缓存中获取对象
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		if (isStop()) {
			return null;
		}
		logger.debug(new StringBuffer("get object from fixedCache... key：").append(key));
		return fixedCache.get(key);
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
		return fixedCache.containsKey(key);
	}

	/**
	 * 删除缓存
	 * 
	 * @param key
	 */
	public static void remove(String key) {
		logger.debug(new StringBuffer("remove object from fixedCache... key：").append(key));
		fixedCache.remove(key);
	}

	/**
	 * 刷新缓存
	 */
	public static void flush() {
		fixedCache.flush();
	}

	/**
	 * 根据类型删除缓存
	 * 
	 * @param _class
	 */
	// public static void removeCacheByClass(Class _class) {
	// List list = getKeys();
	// for (int i = 0; i < list.size(); i++) {
	// String cacheKey = String.valueOf(list.get(i));
	// if (cacheKey.startsWith("fixedCache_" + _class.getName())) {
	// remove(cacheKey);
	// }
	// }
	// }

	/**
	 * 根据方法名删除缓存
	 * 
	 * @param _class
	 * @param methodName
	 * @param arguments
	 */
	// public static void removeCacheByMethod(Class _class, String methodName,
	// Object... arguments) {
	// String key = FixedCacheManager.getCacheKey(_class, methodName,
	// arguments);
	// remove(key);
	// }

	public static void removeAll() {
		logger.debug("remove all object from fixedCache");
		fixedCache.removeAll();
	}

	public static List getKeys() {
		return fixedCache.getKeys();
	}

	public static int getSize() {
		return fixedCache.getSize();
	}

	public static String getCacheName() {
		return fixedCache.getName();
	}

	/**
	 * 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
	 * 缓存名_+包名+类名+方法名+参数，如fixCache_com.yxw.wechat.service.impl.serviceImpl
	 * .queryUser.User.2c9289d21664d139011664d2a78f0001.0
	 */
	// public static String getCacheKey(Class _class, String methodName,
	// Object... arguments) {
	// StringBuffer sb = new StringBuffer("fixCache_");
	// sb.append(_class.getName()).append(".").append(methodName);
	// if ((arguments != null) && (arguments.length != 0)) {
	// for (int i = 0; i < arguments.length; i++) {
	// sb.append(".").append(arguments[i].toString());
	// }
	// }
	// return sb.toString();
	// }
}
