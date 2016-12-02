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

import com.yxw.framework.common.http.HttpResponse;

/**
 * 调用医院平台接口,并返回数据到标准平台 接口.
 * 设计模式:简单模板模式
 * @author 黄忠英
 * @version 1.0
 * @since 2015年7月28日
 */
public interface ConverHelper {
	/**
	 * 获取xml格式的请求字符串
	 * @return
	 */
	public String getRequestStr();

	/**
	 * 获取HttpResponse对象
	 * @return
	 */
	public HttpResponse getHttpResponse();

	/**
	 * 执行标准接口与医院接口之间的转换
	 * @param iplat
	 * @param conver1
	 * @param conver2
	 * @return
	 */
	public <IPLAT, OPLAT> OPLAT exec(IPLAT iplat, Conver<IPLAT, String> conver1, Conver<String, OPLAT> conver2);
}
