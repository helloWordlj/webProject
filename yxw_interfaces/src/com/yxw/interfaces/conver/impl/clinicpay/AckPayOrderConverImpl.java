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
package com.yxw.interfaces.conver.impl.clinicpay;

import com.yxw.interfaces.conver.BaseConver;
import com.yxw.interfaces.conver.Conver;
import com.yxw.interfaces.vo.clinicpay.AckPayOrderRequest;

/**
 * 诊疗付费-->门诊缴费订单支付
 * @Package: com.yxw.interfaces.entity.clinicpay
 * @ClassName: AckPayOrder
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年6月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class AckPayOrderConverImpl extends BaseConver implements Conver<AckPayOrderRequest, String> {

	@Override
	public String doConver(AckPayOrderRequest t) {
		return null;
	}

}
