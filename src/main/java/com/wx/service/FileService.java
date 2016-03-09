package com.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.util.WeixinUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class FileService {
	public static Logger log = Logger.getLogger(FileService.class);

	private static String uploadFileUrl = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

	private static String dwonloadFileURL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

	public static JSONObject uploadFile(String fileType, String filename,
			String filePath, String appId, String appSecret) {
		String requestUrl = uploadFileUrl.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret))
				.replace("TYPE", fileType);
		File file = new File(filePath);
		String result = "";
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		URL submit = null;
		try {
			submit = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) submit
					.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes(twoHyphens + boundary + end);
			dos.writeBytes("Content-Disposition: form-data; name=\"" + file
					+ "\";filename=\"" + filename + ";filelength=\"" + filePath
					+ ";" + end);
			dos.writeBytes(end);
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			int count = 0;
			while ((count = fis.read(buffer)) != -1) {
				dos.write(buffer, 0, count);
			}
			fis.close();
			dos.writeBytes(end);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
			dos.flush();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			result = br.readLine();
			dos.close();
			is.close();
		} catch (MalformedURLException e) {
			log.error("File upload fail..." + e);
		} catch (IOException e) {
			log.error("File upload fail..." + e);
		}
		return JSONObject.parseObject(requestUrl);
	}

	public static String downloadFile(String mediaId, String appId,
			String appSecret) {
		return dwonloadFileURL.replace("ACCESS_TOKEN",
				WeixinUtil.getToken(appId, appSecret)).replace("MEDIA_ID",
				mediaId);
	}
}
