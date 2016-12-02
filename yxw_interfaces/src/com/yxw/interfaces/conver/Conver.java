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

/**
 * 对象转换接口(返回值为一个对象)
 * @author 黄忠英
 * @version 1.0
 * @since 2015年7月23日
 */
public interface Conver<T,K>{
	/**
	 * 将T对象转换成K对象
	 * @param t
	 * @return
	 */
	public K doConver(T t);
	
}
