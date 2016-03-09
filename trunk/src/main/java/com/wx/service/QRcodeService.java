package com.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.constant.ConstantWeChat;
import com.wx.util.StringUtil;
import com.wx.util.WeixinUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class QRcodeService {
	public static Logger log = Logger.getLogger(QRcodeService.class);

	static String QRCODE_ACTION = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

	static String QRCODE_IMG_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

	static String QRCODE_SCENE = "QR_SCENE";

	static String QRCODE_LIMIT_SCENE = "QR_LIMIT_SCENE";

	public static String getTicket(String actionName, int sceneId,
			String appId, String appSecret) {
		String url = QRCODE_ACTION.replace("TOKEN",
				WeixinUtil.getToken(appId, appSecret));

		String ticket = "";

		String qrdata = "{\"action_name\": \"" + actionName
				+ "\", \"action_info\": {\"scene\": {\"scene_id\": " + sceneId
				+ "}}}";

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", qrdata);
		if (jsonObject != null) {
			if ((StringUtil.isNotEmpty(jsonObject.get("errcode")))
					&& (jsonObject.get("errcode") != "0"))
				log.error("二维码ticket请求失败，errcode:"
						+ jsonObject.getIntValue("errcode") + "，errmsg:"
						+ jsonObject.getString("errmsg"));
			else {
				ticket = jsonObject.getString("ticket");
			}
		}
		return ticket;
	}

	public static String getQrCodeImgURL(String ticket) {
		try {
			ticket = URLEncoder.encode(ticket, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return QRCODE_IMG_URL.replace("TICKET", ticket);
	}
	
	public static void main(String[] args){
		String ticket = getTicket(QRCODE_SCENE, 1231, ConstantWeChat.APPID, ConstantWeChat.APPSECRET);
		String img = getQrCodeImgURL(ticket);
		System.out.println(img);
	}
}
