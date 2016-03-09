package com.wx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.entity.user.UserGroup;
import com.wx.util.StringUtil;
import com.wx.util.WeixinUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class UserGroupService {
	public static Logger log = Logger.getLogger(UserGroupService.class);

	private static String CREATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";

	private static String GET_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";

	private static String GET_USER_GOUP = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";

	private static String UPDATE_GROUP_NAME = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";

	private static String MOVE_USER_TO_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";

	public static String createGroup(String groupName, String appId,
			String appSecret) {
		String id = null;

		String url = CREATE_GROUP_URL.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret));

		String data = "{\"group\":{\"name\":\"" + groupName + "\"}}";

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", data);

		if (jsonObject != null) {
			if ((StringUtil.isNotEmpty(jsonObject.get("errcode")))
					&& (jsonObject.get("errcode") != "0"))
				log.error("创建分组失败errcode:" + jsonObject.getIntValue("errcode")
						+ "，errmsg:" + jsonObject.getString("errmsg"));
			else {
				id = jsonObject.getJSONObject("group").getString("id");
			}
		}
		return id;
	}

	public static List<UserGroup> getGroup(String appId, String appSecret) {
		List<UserGroup> list = new ArrayList<UserGroup>();

		String url = GET_GROUP_URL.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret));

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", null);
		if (jsonObject != null) {
			if ((StringUtil.isNotEmpty(jsonObject.get("errcode")))
					&& (jsonObject.get("errcode") != "0")) {
				log.error("获取分组失败errcode:" + jsonObject.getIntValue("errcode")
						+ "，errmsg:" + jsonObject.getString("errmsg"));
			} else {
				JSONArray arr = jsonObject.getJSONArray("groups");
				for (int i = 0; i < arr.size(); i++) {
					UserGroup group = new UserGroup();
					group.setId(arr.getJSONObject(i).getString("id"));
					group.setName(arr.getJSONObject(i).getString("name"));
					group.setCount(arr.getJSONObject(i).getIntValue("count"));
					list.add(group);
				}
			}
		}
		return list;
	}

	public static String getGroupByOpenid(String openid, String appId,
			String appSecret) {
		String groupid = null;

		String url = GET_USER_GOUP.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret));

		String data = "{\"openid\":\"" + openid + "\"}";
		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", data);

		if (jsonObject != null) {
			if ((StringUtil.isNotEmpty(jsonObject.get("errcode")))
					&& (jsonObject.get("errcode") != "0"))
				log.error("获取分组信息失败rrcode:"
						+ jsonObject.getIntValue("errcode") + "，errmsg:"
						+ jsonObject.getString("errmsg"));
			else {
				groupid = jsonObject.getString("groupid");
			}
		}
		return groupid;
	}

	public static boolean updateGroupName(int id, String name, String appId,
			String appSecret) {
		boolean bo = false;

		String url = UPDATE_GROUP_NAME.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret));

		String data = "{\"group\":{\"id\":" + id + ",\"name\":\"" + name
				+ "\"}}";

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", data);

		if ((jsonObject != null)
				&& (StringUtil.isNotEmpty(jsonObject.getString("errcode")))
				&& (jsonObject.getString("errcode").equals("0"))) {
			bo = true;
		}

		return bo;
	}

	public static boolean moveUserToGroup(String openid, int groupId,
			String appId, String appSecret) {
		boolean bo = false;

		String url = MOVE_USER_TO_GROUP.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret));

		String data = "{\"openid\":\"" + openid + "\",\"to_groupid\":"
				+ groupId + "}";

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", data);

		if ((jsonObject != null)
				&& (StringUtil.isNotEmpty(jsonObject.getString("errcode")))
				&& (jsonObject.getString("errcode").equals("0"))) {
			bo = true;
		}

		return bo;
	}
}
