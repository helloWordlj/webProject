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
package com.yxw.interfaces.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yxw.framework.common.http.HttpResponse;
import com.yxw.framework.config.SystemConfig;
import com.yxw.framework.exception.SystemException;
import com.yxw.interfaces.constants.ResultCodeType;
import com.yxw.interfaces.conver.Conver;
import com.yxw.interfaces.conver.ConverHelper;
import com.yxw.interfaces.conver.ConverHelperImpl;
import com.yxw.interfaces.vo.Response;
import com.yxw.interfaces.vo.ResponsePlus;

/**
 * @Package: com.yxw.interfaces.service
 * @ClassName: AbstractYxwService
 * @Statement: <p>通用从标准接口到医院接口,从医院接口到标准接口转换的抽象类</p>
 * @JDK version used: 
 * @Author: 黄忠英
 * @Create Date: 2015年7月23日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public abstract class AbstractYxwService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	//重要日志
	protected Logger importanceLog = LoggerFactory.getLogger("importance");
	/**
	 * 接口地址
	 */
	protected final String interfaceUrl = SystemConfig.getStringValue("url");

	/**
	 * 简单执行 从标准平台到医院平台,并从医院平台回标准平台 入口
	 * @param iplat	标准平台请求参数(如:MZPatientRequest、AckPayOrderRequest)
	 * @param conver1 将标准平台输入参数(iplat)转为医院平台输入参数
	 * @param conver2 将医院返回数据转为标准平台返回参数(如:MZPatient、AckPayOrder)
	 * @param method 当前调用的方法名(如:getMZPatient)
	 * @return
	 */
	protected <IPLAT, OPLAT> ResponsePlus doExec(IPLAT iplat, Conver<IPLAT, String> conver1, Conver<String, OPLAT> conver2, String method) {
		return doExec(iplat, conver1, conver2, method, true, null, null);
	}

	protected <IPLAT, OPLAT> ResponsePlus doExec(IPLAT iplat, Conver<IPLAT, String> conver1, Conver<String, OPLAT> conver2, String method,
			boolean isHisLimit, String resultMessage, ConverHelper converHelper) {
		ResponsePlus responsePlus = null;

		Response response = null;
		//若不指定converHelper,则使用默认实现.
		if (converHelper == null) {
			converHelper = new ConverHelperImpl(interfaceUrl);
		}
		try {
			Object out = converHelper.exec(iplat, conver1, conver2);

			response = handleResponse(converHelper, out, method, isHisLimit, resultMessage);
		} catch (Exception e) {
			e.printStackTrace();
			response = handleErr(method, converHelper.getRequestStr(), e);
		}

		responsePlus = new ResponsePlus(response, converHelper);
		return responsePlus;
	}

	/**
	 * 处理医院接口响应结果
	 * @param converHelper
	 * @param retObj
	 * @param method
	 * @param isHisLimit 是否符合医院限定
	 * @param resultMessage 描述
	 * @return
	 */
	protected Response handleResponse(ConverHelper converHelper, Object retObj, String method, boolean isHisLimit, String resultMessage) {
		Response response = new Response();

		if (retObj != null) {
			// 成功
			response.setResultCode(ResultCodeType.SUCCESS[0]);
			response.setResultMessage(ResultCodeType.SUCCESS[1]);
			response.setResult(retObj);
		} else if (!isHisLimit) {
			//成功,但不符合医院限定
			response.setResultCode(ResultCodeType.SUCCESS_NOT_HIS_LIMIT[0]);
			response.setResultMessage(resultMessage);
		} else if (HttpResponse.isRequestSuccess(converHelper.getHttpResponse())) {
			//成功,但未查询到数据
			response.setResultCode(ResultCodeType.SUCCESS_NO_DATA[0]);
			response.setResultMessage(ResultCodeType.SUCCESS_NO_DATA[1]);
		} else {
			//请求医院接口异常
			printLog(method, ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[0], ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[1],
					converHelper.getRequestStr(), null);
			response.setResultCode(ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[0]);
			response.setResultMessage(ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[1]);
		}
		return response;
	}

	/**
	 * 写错误信息到日志文件
	 * @param method
	 * @param e
	 */
	protected Response handleErr(String method, String requestStr, Exception e) {
		Response response = new Response();
		String resultCode = "";
		String resultMessage = "";
		//这里区分请求医院接口异常和接口转换程序异常
		if (e instanceof SystemException) {
			//请求医院接口异常
			resultCode = ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[0];
			resultMessage = ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[1];
		} else {
			//接口转换程序异常
			resultCode = ResultCodeType.INTERFACE_CONVERSION_PROGRAM_ERROR[0];
			resultMessage = ResultCodeType.INTERFACE_CONVERSION_PROGRAM_ERROR[1];
		}
		printLog(method, resultCode, resultMessage, requestStr, e);

		//统一响应为请求医院接口异常
		response.setResultCode(ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[0]);
		response.setResultMessage(ResultCodeType.REQUEST_HIS_INTERFACE_ERROR[1]);

		return response;
	}

	/**
	 * 异常信息日志打印
	 * @param method
	 * @param resultCode
	 * @param resultMessage
	 * @param requestXml
	 * @param e
	 */
	protected void printLog(String method, String resultCode, String resultMessage, String requestXml, Exception e) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("异常信息:[method=").append(method).append(",resultCode=").append(resultCode).append(",message=").append(resultMessage)
				.append(",requestXml=").append(requestXml).append("]");
		if (e != null) {
			logger.error(stringBuilder.toString(), e);
		} else {
			logger.error(stringBuilder.toString());
		}
	}
}
