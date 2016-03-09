package com.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.constant.ConstantWeChat;
import com.wx.entity.AccessTokenOAuth;
import com.wx.entity.user.UserWeiXin;
import com.wx.util.StringUtil;
import com.wx.util.WeixinUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.log4j.Logger;

public class OAuthService {
	public static Logger log = Logger.getLogger(OAuthService.class);

	public static String OAUTH = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

	public static String GET_USER_INFO_OAUTH = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	public static String GET_ACCESS_TOKEN_OAUTH = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	public static String getOauthUrl(String redirectUrl, String charset,
			String scope) {
		String url = "";
		try {
			url = OAUTH
					.replace("APPID", ConstantWeChat.APPID)
					.replace("REDIRECT_URI",
							URLEncoder.encode(redirectUrl, charset))
					.replace("SCOPE", scope);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}

	public static AccessTokenOAuth getOAuthAccessToken(String code) {
		String url = GET_ACCESS_TOKEN_OAUTH
				.replace("APPID", ConstantWeChat.APPID)
				.replace("SECRET", ConstantWeChat.APPSECRET)
				.replace("CODE", code);

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", null);

		AccessTokenOAuth accessTokenOAuth = null;

		if (jsonObject != null) {
			if ((StringUtil.isNotEmpty(jsonObject.get("errcode")))
					&& (jsonObject.get("errcode") != "0")) {
				log.error("获取access_token失败 errcode:"
						+ jsonObject.getIntValue("errcode") + "，errmsg:"
						+ jsonObject.getString("errmsg"));
			} else {
				accessTokenOAuth = new AccessTokenOAuth();
				accessTokenOAuth.setAccessToken(jsonObject
						.getString("access_token"));
				accessTokenOAuth.setExpiresIn(jsonObject.getIntValue("expires_in"));
				accessTokenOAuth.setRefreshToken(jsonObject
						.getString("refresh_token"));
				accessTokenOAuth.setOpenid(jsonObject.getString("openid"));
				accessTokenOAuth.setScope(jsonObject.getString("scope"));
			}
		}
		return accessTokenOAuth;
	}

	public static UserWeiXin getUserInfoOauth(String token, String openid) {
		UserWeiXin user = null;
		if (token != null) {
			String url = GET_USER_INFO_OAUTH.replace("ACCESS_TOKEN", token)
					.replace("OPENID", openid);

			JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", null);

			if (jsonObject != null) {
				if ((StringUtil.isNotEmpty(jsonObject.get("errcode")))
						&& (jsonObject.get("errcode") != "0")) {
					log.error("获取用户信息失败 errcode:"
							+ jsonObject.getIntValue("errcode") + "，errmsg:"
							+ jsonObject.getString("errmsg"));
				} else {
					user = new UserWeiXin();
					user.setOpenid(jsonObject.getString("openid"));
					user.setNickname(jsonObject.getString("nickname"));
					user.setSex(Integer.valueOf(jsonObject.getIntValue("sex")));
					user.setCity(jsonObject.getString("city"));
					user.setCountry(jsonObject.getString("country"));
					user.setProvince(jsonObject.getString("province"));
					user.setLanguage(jsonObject.getString("language"));
					user.setPrivilege(jsonObject.getString("privilege"));
					user.setHeadimgurl(jsonObject.getString("headimgurl"));
				}
			}
		}
		return user;
	}
}
