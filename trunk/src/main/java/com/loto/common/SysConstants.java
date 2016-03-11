package com.loto.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wx.entity.AccessToken;

/**
 * @description 系统缓存
 *
 * @author xuys
 * 
 * @time 2015年3月30日 下午1:57:04
 **/
public class SysConstants {
	//系统模板缓存
	public static Map<String, List<String>> sysTemplateCache = new HashMap<String, List<String>>();
	
	//调用微信接口token缓存
	public static Map<String, AccessToken> sysAccessTokenCache = new HashMap<String, AccessToken>();
	
	//配件套餐类别名称缓存
	public static Map<Integer, String> sysSuiteTypeCache = new HashMap<Integer, String>();
	
	/**
	 * @description 缓存接口调用凭证token
	 *
	 * @author xuys
	 * 
	 * @time 2015年4月2日 下午5:07:04
	 *
	 * @param
	 *
	 */
	public static void setCacheToken(AccessToken token, boolean reset){
		if (reset) {
			token = new AccessToken();
		}
		sysAccessTokenCache.put(Constant.SYS_CACHE_KEY_WXTOKEN, token);
	}
	
	/**
	 * @description 获取系统缓存token
	 *
	 * @author xuys
	 * 
	 * @time 2015年4月2日 下午5:10:32
	 *
	 * @param
	 *
	 */
	public static AccessToken getCacheToken(){
		return sysAccessTokenCache.get(Constant.SYS_CACHE_KEY_WXTOKEN);
	}
	
	/**
	 * @description 缓存js api票据
	 *
	 * @author xuys
	 * 
	 * @time 2015年4月2日 下午6:08:11
	 *
	 * @param
	 *
	 */
	public static void setCacheJsapiTicket(AccessToken token, boolean reset){
		if (reset) {
			token = new AccessToken();
		}
		sysAccessTokenCache.put(Constant.SYS_CACHE_KEY_JSAPI, token);
	}
	
	/**
	 * @description 获得js api调用票据
	 *
	 * @author xuys
	 * 
	 * @time 2015年4月2日 下午6:09:38
	 *
	 * @param
	 *
	 */
	public static AccessToken getCacheTicket(){
		return sysAccessTokenCache.get(Constant.SYS_CACHE_KEY_JSAPI);
	}
	
	/**
	 * @description 清除token缓存
	 *
	 * @author xuys
	 * 
	 * @time 2015年4月23日 下午2:36:05
	 *
	 * @param
	 *
	 */
	public static void clearTokenCache(){
		sysAccessTokenCache.clear();
	}
	
	/**
	 * @description 缓存业务通知模板
	 *
	 * @author xuys
	 * 
	 * @time 2015年3月30日 下午2:07:39
	 *
	 * @param
	 *
	 */
	public static void setTemplateCache(Map<String, List<String>> templateMap, boolean reset){
		if (reset) {
			sysTemplateCache = new HashMap<String, List<String>>();
		}
		sysTemplateCache = templateMap;
	}
	
	/**
	 * @description 获得模板的关键字集合
	 *
	 * @author xuys
	 * 
	 * @time 2015年3月30日 下午2:13:58
	 *
	 * @param
	 *
	 */
	public static List<String> getTemplateKeywordList(String code){
		return sysTemplateCache.get(code);
	}
	
	/**
	 * @description 缓存配件套餐
	 * @author xuys
	 * @time 2015年7月6日 下午3:33:20
	 * @param
	 *
	 */
	public static void setSuiteTypeCache(Map<Integer, String> suiteTypeMap, boolean reset){
		if (reset) {
			sysSuiteTypeCache = new HashMap<Integer, String>();
		}
		sysSuiteTypeCache = suiteTypeMap;
	}
	
	
}
