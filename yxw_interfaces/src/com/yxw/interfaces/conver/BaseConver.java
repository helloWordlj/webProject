/**
 * <html>
 * <body>
 *  <P>  Copyright(C)版权所有 - 2015 广州医享网络科技发展有限公司.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年7月23日</p>
 *  <p> Created by 黄忠英</p>
 *  </body>
 * </html>
 */
package com.yxw.interfaces.conver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.yxw.framework.common.http.HttpResponse;
import com.yxw.framework.common.http.PostParameter;
import com.yxw.framework.config.SystemConfig;
import com.yxw.framework.exception.SystemException;
import com.yxw.interfaces.service.HttpThreadPool;

/**
 * @author 黄忠英
 * @version 1.0
 * @since 2015年7月23日
 */
public class BaseConver {
	protected Logger logger = Logger.getLogger(this.getClass());

	//***************医院接口配置信息*****************//
	/**
	 * soap命名空间名称
	 */
	protected final String envelopeNamespaceName = SystemConfig.getStringValue("envelopeNamespaceName");
	/**
	 * soap命名空间地址
	 */
	protected final String envelopeNamespaceUrl = SystemConfig.getStringValue("envelopeNamespaceUrl");
	/**
	 * 自定义命名空间名称
	 */
	protected final String customNamespaceName = SystemConfig.getStringValue("customNamespaceName");
	/**
	 * 自定义命名空间url
	 */
	protected final String customNamespaceUrl = SystemConfig.getStringValue("customNamespaceUrl");

	/**
	 * 获取xml格式请求参数字符串
	 * 
	 * @param element
	 * @return
	 */
	protected String getXmlRequestStr(Element element) {
		return getXmlRequestStr(new Element[] { element });
	}

	/**
	 * 获取xml格式请求参数字符串
	 * @param elements
	 * @return
	 */
	protected String getXmlRequestStr(Element... elements) {
		// 拼接xml格式请求报文头
		Element envElement = DocumentHelper.createElement(envelopeNamespaceName + ":Envelope");
		envElement.addNamespace(envelopeNamespaceName, envelopeNamespaceUrl);
		// 添加自定义命名空间
		if (StringUtils.isNotBlank(customNamespaceName)) {
			envElement.addNamespace(customNamespaceName, customNamespaceUrl);
		}
		envElement.addElement(envelopeNamespaceName + ":Header");
		Element bodyElement = envElement.addElement(envelopeNamespaceName + ":Body");

		if (elements != null) {
			for (Element element : elements) {
				bodyElement.add(element);
			}
		}
		//System.out.println(envElement.asXML());
		return envElement.asXML();
	}

	/**
	 * 获取处理后的xml响应报文 document对象
	 * 
	 * @param responseXmlStr
	 * @param hisInterface
	 * @return
	 */
	protected Document getResponseXML(String responseXmlStr, String node) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(getResponseXMLStr(responseXmlStr, node));
		} catch (DocumentException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		return document;
	}

	/**
	 * 获取处理后的xml响应报文字符串
	 * 
	 * @param responseXmlStr
	 * @param hisInterface
	 * @return
	 */
	protected String getResponseXMLStr(String responseXmlStr, String node) {
		// 处理转义
		String xmlStr = StringEscapeUtils.unescapeXml(responseXmlStr);
		// 截取结果集
		if (xmlStr.lastIndexOf("</" + node + ">") != -1) {
			xmlStr = xmlStr.substring(xmlStr.indexOf("<" + node + ">"), xmlStr.lastIndexOf("</" + node + ">") + ( "</" + node + ">" ).length());
		} else {
			// 首先清除节点中的空格,比如:<GetPatientInfoResult nas="ss"
			// />会变成<GetPatientInfoResult nas="ss"/>
			xmlStr = xmlStr.replaceAll("\\s*/>", "/>");
			xmlStr = xmlStr.substring(xmlStr.indexOf("<" + node + "/>"), xmlStr.lastIndexOf("<" + node + "/>") + ( "<" + node + "/>" ).length());
		}

		// 过滤掉xml声明,有些webservice返回的xml格式不是规范的xml格式
		// xmlStr =
		// xmlStr.replaceAll("<\\?xml\\s+version=\"1.0\"\\s+encoding=\"(.*?)\"\\?>",
		// "");
		xmlStr = xmlStr.replaceAll("<\\?xml([\\s\\S]*)\\?>", "");
		return xmlStr;
	}

	/**
	 * 处理空字符串
	 * 
	 * @param value
	 * @return
	 */
	protected String getValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			return value;
		} else {
			return null;
		}
	}

	/**
	 * 根据医生代码从php获取医生信息
	 * 
	 * @param doctorIds
	 * @return
	 */
	protected Map<String, Map<String, Object>> getDoctorsByPhp(String doctorIds) {
		PostParameter controller = new PostParameter("controller", SystemConfig.getStringValue("controller"));
		PostParameter action = new PostParameter("action", SystemConfig.getStringValue("action"));
		PostParameter secret = new PostParameter("secret", SystemConfig.getStringValue("secret"));
		PostParameter appId = new PostParameter("appId", SystemConfig.getStringValue("appId"));
		PostParameter doctorCode = new PostParameter("doctorCode", doctorIds);
		List<PostParameter> postParameters = new ArrayList<PostParameter>();
		postParameters.add(controller);
		postParameters.add(action);
		postParameters.add(secret);
		postParameters.add(appId);
		postParameters.add(doctorCode);
		HttpResponse httpResponse = null;
		try {
			httpResponse = HttpThreadPool.client.post(SystemConfig.getStringValue("getDoctorsByPhp"), postParameters);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			//此处若不抛出异常会导致数据不完整
			throw new SystemException();
		}

		if (HttpResponse.isRequestSuccess(httpResponse)) {
			Map<String, Object> map = JSONObject.toJavaObject(httpResponse.asJSONObject(), Map.class);
			String resultCode = (String) map.get("code");
			if ("40000".equals(resultCode)) {
				Map<String, Object> results = (Map<String, Object>) map.get("result");
				List<Map<String, Object>> items = (List<Map<String, Object>>) results.get("item");
				if (!CollectionUtils.isEmpty(items)) {
					Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
					for (Map<String, Object> temp : items) {
						String doctorId = (String) temp.get("doctorCode");
						resultMap.put(doctorId, temp);
					}
					return resultMap;
				}
			}
		}
		return null;
	}
}
