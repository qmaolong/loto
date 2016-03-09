package com.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.entity.customer.CustomerBaseMessage;
import com.wx.entity.customer.MediaMessage;
import com.wx.entity.customer.MusicMessage;
import com.wx.entity.customer.NewsMessage;
import com.wx.entity.customer.TextMessage;
import com.wx.entity.customer.VideoMessage;
import com.wx.util.StringUtil;
import com.wx.util.WeixinUtil;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class CustomService {
	public static Logger log = Logger.getLogger(CustomService.class);

	private static String CUSTOME_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	public static Map<String, CustomerBaseMessage> bulidMessageMap = new HashMap<String, CustomerBaseMessage>();

	static {
		bulidMessageMap.put("text", new TextMessage());
		bulidMessageMap.put("news", new NewsMessage());
		bulidMessageMap.put("image", new MediaMessage());
		bulidMessageMap.put("voice", new MediaMessage());
		bulidMessageMap.put("video", new VideoMessage());
		bulidMessageMap.put("music", new MusicMessage());
	}
	/**
	 * 推送用户消息
	 * @param obj
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static boolean sendCustomerMessage(Object obj, String appId,
			String appSecret) {
		boolean bo = false;
		String url = CUSTOME_URL.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret));
		JSONObject json = (JSONObject)JSONObject.toJSON(obj);
		System.out.println(json);
		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST",
				json.toString());
		if ((jsonObject != null)
				&& (StringUtil.isNotEmpty(jsonObject.getString("errcode")))
				&& (jsonObject.getString("errcode").equals("0"))) {
			bo = true;
		}

		return bo;
	}
	
	/**
	 * 构造信息
	 * @param toUser
	 * @param msgType
	 * @return
	 */
	public static Object bulidCustomerBaseMessage(String toUser, String msgType) {
		CustomerBaseMessage message = (CustomerBaseMessage) bulidMessageMap
				.get(msgType);
		message.setTouser(toUser);
		message.setMsgtype(msgType);
		return message;
	}
}
