/**
 * <html>
 * <body>
 *  <P>  Copyright 2014-2015 www.yx129.com Group.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015-7-4</p>
 *  <p> Created by Yuce</p>
 *  </body>
 * </html>
 */
package com.yxw.mobileapp.invoke;

import com.yxw.mobileapp.invoke.dto.Request;
import com.yxw.mobileapp.invoke.dto.Response;

/**
 * @Package: com.yxw.mobileapp.invoke
 * @ClassName: OutsideInvokeService
 * @Statement: <p>对外提供的接口服务声明</p>
 * @JDK version used: 1.6
 * @Author: Yuce
 * @Create Date: 2015-7-4
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public interface OutsideInvokeService {

	/**
	 * 
	 * @return
	 
	public RequestResult stopDoctor();*/

	/**
	 * 医生停诊接口 新版本
	 
	public RequestResult stopReg(StopRegister sr);*/

	/**
	 * 医生停诊接口 旧版本
	 
	public RequestResult stopRegistration(StopRegisterArg sra);*/

	/**
	 * 退费接口
	 
	public RequestResult refundGeneral(RgParams rg);*/

	/**
	 * 订单查询接口
	
	public RequestResult ordersQuery(OrdersParams op); */

	/**
	 * 手动退费接口
	 * @param refund
	 * @return
	 
	public RequestResult manualRefund(ManuaRefundParams refund);*/

	/**
	 * 通用接口
	 * @param request
	 * @return
	 */
	public Response openService(Request request);
}
