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
package com.yxw.interfaces.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yxw.framework.common.spring.ext.SpringContextHolder;
import com.yxw.framework.config.SystemConfig;
import com.yxw.interfaces.service.YxwOpenService;
import com.yxw.mobileapp.invoke.OutsideInvokeService;
import com.yxw.mobileapp.invoke.dto.Request;
import com.yxw.mobileapp.invoke.dto.Response;

/**
 * @Package: com.yxw.interfaces.service.impl
 * @ClassName: YxwOpenServiceImpl
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年8月20日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class YxwOpenServiceImpl implements YxwOpenService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 对外接口ID
	 */
	protected final String serviceId = SystemConfig.getStringValue("serviceId");

	@Override
	public Response openService(Request request) {
		logger.info("openService:methodCode=" + request.getMethodCode() + ",params=" + request.getParams());
		Response response = null;
		try {
			OutsideInvokeService outsideInvokeService = SpringContextHolder.getBean(serviceId);
			if (outsideInvokeService != null) {
				response = outsideInvokeService.openService(request);
			} else {
				//请求接口异常
				response = new Response("-1", "exception");
				logger.error("openService:methodCode=" + request.getMethodCode() + ",params=" + request.getParams());
			}
			if (response == null) {
				//请求接口异常
				response = new Response("-1", "exception");
				logger.error("openService:methodCode=" + request.getMethodCode() + ",params=" + request.getParams());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("openService:methodCode=" + request.getMethodCode() + ",params=" + request.getParams(), e);
			//请求接口异常
			response = new Response("-1", "exception");
		}
		return response;
	}
}
