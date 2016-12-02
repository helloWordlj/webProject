/**
 * <html>
 * <body>
 *  <P>  Copyright(C)版权所有 - 2015 广州医享网络科技发展有限公司.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年2月10日</p>
 *  <p> Created by Administrator</p>
 *  </body>
 * </html>
 */

package com.yxw.interfaces.service;

import java.io.Serializable;

import com.yxw.framework.common.http.HttpClient;
import com.yxw.framework.config.SystemConfig;

/**
 * 创建http多线程
 * 
 * @author 申午武
 * @version 1.0
 * @since 2015年2月10日
 */

public class HttpThreadPool implements Serializable {

	private static final long serialVersionUID = -166875462415162722L;
	// protected static HttpClient client = new HttpClient();

	// 如果希望自己设置HttpClient的各种参数，可以使用下面的构造方法
	public static HttpClient client = new HttpClient(SystemConfig.getInteger("httpThreadPoolSize", 20), 30000, 30000, false);
}
