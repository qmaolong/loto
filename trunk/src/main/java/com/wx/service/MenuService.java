package com.wx.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSONObject;
import com.wx.entity.menu.Menu;
import com.wx.util.WeixinUtil;

import org.apache.log4j.Logger;

public class MenuService {
	public static Logger log = Logger.getLogger(MenuService.class);

	public static String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	public static Integer createMenu(String jsonMenu, String appId,
			String appSecret) {
		String token = WeixinUtil.getToken(appId, appSecret);
		if (token != null) {
			return Integer.valueOf(createMenu(jsonMenu, token));
		}
		return null;
	}

	public static Integer createMenu(Menu menu, String appId, String appSecret) {
		String token = WeixinUtil.getToken(appId, appSecret);
		if (token != null) {
			return Integer.valueOf(createMenu(menu, token));
		}
		return null;
	}

	public static int createMenu(String jsonMenu, String accessToken) {
		int result = 0;

		String url = MENU_CREATE.replace("ACCESS_TOKEN", accessToken);

		JSONObject jsonObject = WeixinUtil.httpsRequest(url, "POST", jsonMenu);

		if ((jsonObject != null) && (jsonObject.getIntValue("errcode") != 0)) {
			result = jsonObject.getIntValue("errcode");
			log.error("创建菜单失败 errcode:" + jsonObject.getIntValue("errcode")
					+ "，errmsg:" + jsonObject.getString("errmsg"));
		}

		return result;
	}

	public static int createMenu(Menu menu, String accessToken) {
		String jsonMenu = JSONObject.toJSONString(menu);
		return createMenu(jsonMenu, accessToken);
	}
	
	//根据Menu.txt文件创建自定义菜单
	public static int createMenu(String accessToken){
		String jsonMenu = "";
		try {
			String encoding = "UTF-8";
			File file = new File("src/Menu.txt");
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					jsonMenu += lineTxt;
				}
				read.close();
			} else {
				log.error("找不到指定的文件");
			}
		} catch (Exception e) {
			log.error("读取文件内容出错");
			e.printStackTrace();
		}
		return createMenu(jsonMenu, accessToken);
	}
	
}
