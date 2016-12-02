/**
 * <html>
 * <body>
 *  <P>  Copyright(C)版权所有 - 2015 广州医享网络科技发展有限公司.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年1月28日</p>
 *  <p> Created by 谢家贵</p>
 *  </body>
 * </html>
 */

package com.yxw.framework.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 谢家贵
 * @version 1.0
 */

public class CookieUtils {
    /**
     * 设置cookie.
     * 
     * @param response
     *            响应
     * @param name
     *            cookie名字
     * @param value
     *            cookie值
     * @param timeOut
     *            有效时间
     * @param cookieDomain
     * @param path
     *            设置cookie路径
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int timeOut,
            String cookieDomain, String path) {
        
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(timeOut);
        cookie.setDomain(cookieDomain);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    
    /**
     * 获取cookie信息
     * 
     * @param request
     *            请求对象
     * @param name
     *            cookie名称
     * @return String.
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (int idx = 0; idx < cookies.length; idx++) {
            if ((cookies[idx].getName()).equals(name)) {
                return cookies[idx].getValue();
            }
        }
        return null;
    }
}
