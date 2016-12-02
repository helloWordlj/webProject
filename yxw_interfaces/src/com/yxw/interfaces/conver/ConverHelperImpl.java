/**
 * <html>
 * <body>
 *  <P>  Copyright(C)版权所有 - 2015 广州医享网络科技发展有限公司.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年7月28日</p>
 *  <p> Created by 黄忠英</p>
 *  </body>
 * </html>
 */
package com.yxw.interfaces.conver;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yxw.framework.common.http.HttpConstants;
import com.yxw.framework.common.http.HttpResponse;
import com.yxw.framework.exception.SystemException;
import com.yxw.framework.utils.BeanUtils;
import com.yxw.interfaces.service.HttpThreadPool;

/**
 * @author 黄忠英
 * @version 1.0
 * @since 2015年7月28日
 */
public class ConverHelperImpl implements ConverHelper {
	private String interfaceUrl;

	private HttpResponse httpResponse;
	private String requestStr;

	//已经执行,不再允许重复执行.
	private AtomicBoolean isExeced = new AtomicBoolean(false);

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	//日志记录最大长度
	protected int logMaxLength = 800;

	/**
	 * @param interfaceUrl 平台接口地址
	 */
	public ConverHelperImpl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}

	/**
	 * 
	 * 功能流程:
	 * 1.执行将标准平台入参解析成医院平台入参
	 * 2.并调用医院平台接口
	 * 3.之后将医院平台返回的字符串(出参)转成标准平台出参
	 * @param iplat	标准平台请求参数(如:MZPatientRequest、AckPayOrderRequest)
	 * @param conver1 将标准平台输入参数(iplat)转为医院平台输入参数
	 * @param conver2 将医院返回数据转为标准平台返回参数(如:MZPatient、AckPayOrder)
	 * @return
	 */
	public <IPLAT, OPLAT> OPLAT exec(IPLAT iplat, Conver<IPLAT, String> conver1, Conver<String, OPLAT> conver2) {

		return exec0(iplat, conver1, conver2);
	}

	protected <IPLAT, OPLAT> OPLAT exec0(IPLAT iplat, Conver<IPLAT, String> conver1, Conver<String, OPLAT> conver2) {

		if (!isExeced.compareAndSet(false, true)) {
			throw new UnsupportedOperationException("此方法不允许重复执行");
		}

		String responseStr = doRequest(iplat, conver1);
		OPLAT out = doResponse(responseStr, conver2);

		return out;
	}

	protected <IPLAT> String doRequest(IPLAT iplat, Conver<IPLAT, String> conver1) {
		if (iplat != null) {
			log("request obj:" + iplat.getClass().getName() + "[" + BeanUtils.toMap(iplat) + "]");
		}
		requestStr = conver1.doConver(iplat);
		log("request str:" + requestStr);
		// 发起请求
		httpResponse = httpPost(interfaceUrl, requestStr);

		String responseStr = null;
		if (HttpResponse.isRequestSuccess(httpResponse)) {
			responseStr = httpResponse.asString();
		}
		log("response str:" + responseStr);

		return responseStr;
	}

	protected <OPLAT> OPLAT doResponse(String responseStr, Conver<String, OPLAT> conver2) {
		OPLAT out = null;
		if (StringUtils.isNotBlank(responseStr)) {
			out = conver2.doConver(responseStr);
		}
		return out;
	}

	protected HttpResponse httpPost(String interfaceUrl, String requestStr) {
		try {
			HttpResponse httpResponse =
					HttpThreadPool.client.post(interfaceUrl, requestStr, HttpConstants.XML_TYPE, HttpConstants.CHARACTER_ENCODING_UTF8);
			return httpResponse;
		} catch (Exception e) {
			//此处抛出异常以便外层catch能够捕获和区分异常
			throw new SystemException(e);
		}
	}

	protected void log(Object log, Throwable e) {
		if (logger.isInfoEnabled()) {
			String logStr = log == null ? "" : log.toString();
			if (logStr.length() > logMaxLength) {
				logStr = logStr.substring(0, logMaxLength) + "...";
			}
			if (e == null) {
				logger.info(logStr);
			} else {
				logger.info(logStr, e);
			}

		}
	}

	protected void log(Object log) {
		log(log, null);
	}

	/**
	 * @return the httpResponse
	 */
	public HttpResponse getHttpResponse() {
		return httpResponse;
	}

	/**
	 * @return the requestStr
	 */
	public String getRequestStr() {
		return requestStr;
	}
}
