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

import java.util.concurrent.ConcurrentHashMap;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import com.yxw.framework.common.cache.impl.Ehcache;
import com.yxw.framework.common.spring.ext.SpringContextHolder;

/**
 * 缓存工厂，用于获取不同的缓存
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年3月3日
 */

public class CacheFactory {
    private static Object cacheManager = SpringContextHolder.getBean("cacheManager");
    /**
     * 缓存实例
     */
    public static ConcurrentHashMap<String, com.yxw.framework.common.cache.Cache> cacheMap = new ConcurrentHashMap<String, com.yxw.framework.common.cache.Cache>();
    
    /**
     * 获取cache实例
     * 
     * @param cacheName
     * @return
     */
    public static com.yxw.framework.common.cache.Cache getCache(String cacheName) {
        com.yxw.framework.common.cache.Cache cache = null;
        if (!cacheMap.containsKey(cacheName)) {
            if (cacheManager instanceof CacheManager) {
                CacheManager manager = (CacheManager) cacheManager;
                net.sf.ehcache.Cache temp = (Cache) manager.getCache(cacheName);
                cache = new Ehcache(cacheName, temp);
            }
            cacheMap.put(cacheName, cache);
        } else {
            cache = cacheMap.get(cacheName);
        }
        return cache;
    }
    
}
