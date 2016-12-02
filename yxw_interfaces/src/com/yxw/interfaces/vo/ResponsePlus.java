/**
 * <html>
 * <body>
 *  <P>  Copyright 2014-2015 www.yx129.com Group.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年4月28日</p>
 *  <p> Created by 黄忠英</p>
 *  </body>
 * </html>
 */
package com.yxw.interfaces.vo;

import com.yxw.framework.common.http.HttpResponse;
import com.yxw.interfaces.conver.ConverHelper;

/**
 * @Package: com.yxw.interfaces.vo
 * @ClassName: ResponsePlus
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 黄忠英
 * @Create Date: 2015年7月30日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class ResponsePlus {

	private Response response;
	private ConverHelper converHelper;

	/**
	 * 
	 */
	public ResponsePlus() {
		super();
	}

	/**
	 * @param response
	 * @param requestStr
	 * @param httpResponse
	 */
	public ResponsePlus(Response response, ConverHelper converHelper) {
		super();
		this.response = response;
		this.converHelper = converHelper;
	}

	/**
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(Response response) {
		this.response = response;
	}

	/**
	 * @return the requestStr
	 */
	public String getRequestStr() {
		return getConverHelper().getRequestStr();
	}

	/**
	 * @return the httpResponse
	 */
	public HttpResponse getHttpResponse() {
		return getConverHelper().getHttpResponse();
	}

	/**
	 * @return the converHelper
	 */
	public ConverHelper getConverHelper() {
		return converHelper;
	}

}
