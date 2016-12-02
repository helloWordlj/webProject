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

import net.sf.ehcache.CacheManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 缓存管理器
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年3月3日
 */
public class CacheManagerFactoryBean implements InitializingBean, FactoryBean, DisposableBean {

	protected final Log logger = LogFactory.getLog(getClass());

	private String configPath;
	/**
	 * ehcache缓存管理器
	 */
	private CacheManager cacheManager;

	public CacheManagerFactoryBean() {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Initializing CacheManager...");
		cacheManager = CacheManager.create(ClassLoader.getSystemResource("").getPath() + configPath);
		// cacheManager = CacheManager.create(configPath);
	}

	@Override
	public Object getObject() {
		return cacheManager;
	}

	@Override
	public Class getObjectType() {
		if (cacheManager != null) {
			return cacheManager.getClass();
		}
		return null;

	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void destroy() {
		logger.info("Shutting down CacheManager...");
		cacheManager.shutdown();
	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

}
