package com.wx.constant;

import com.wx.util.ConfigUtil;

public class ConstantWeChat {
	public static String TOKEN = ConfigUtil.get("token");

	public static String APPID = ConfigUtil.get("appId");

	public static String APPSECRET = ConfigUtil.get("appSecret");
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	public static final String EVENT_TYPE_CLICK = "CLICK";
	public static final String SCOPE_SNSAPI_BASE = "snsapi_base";
	public static final String SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";
	
	public static void main(String[] args){
		System.out.println(APPID);
		System.out.println(APPSECRET);
		System.out.println(TOKEN);
	}
}