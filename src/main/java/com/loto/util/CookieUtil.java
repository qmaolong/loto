package com.loto.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @author wangqiang
 *
 */
public class CookieUtil {
	private static final String DEFAULT_PATH = "/";
	private static final int DEFAULT_EXPIRE = 24 * 3600;
	/**
	 * 添加cookie
	 * @param name
	 * @param value
	 * @param response
	 * @param age
	 */
	public static void addCookie(String name,String value,HttpServletResponse response,int age){
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(age);
		cookie.setPath(DEFAULT_PATH);
		response.addCookie(cookie);
	}
	public static void addCookie(String name,String value,HttpServletResponse response){
		addCookie(name,value,response,DEFAULT_EXPIRE);
	}
	
	/**
	 * 根据cookie名称找到cookie的值
	 * @param name
	 * @param request
	 * @return
	 */
	public static String findCookie(String name,HttpServletRequest request){
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equals(name)){
					value = cookie.getValue();
				}
			}
		}
		return value;
	}
	
	/**
	 * 删除指定name的cookie
	 * @param name
	 * @param response
	 */
	public static void deleteCookie(String name,HttpServletResponse response){
		Cookie cookie = new Cookie(name,"");
		cookie.setMaxAge(0);
		cookie.setPath(DEFAULT_PATH);
		response.addCookie(cookie);
	}
	
	/**
	 * 删除根路径下所有cookie
	 * @param request
	 * @param response
	 */
	public static void deleteAllCookie(HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				deleteCookie(cookie.getName(), response);
			}
		}
	}
	
}
