package com.loto.util;

import java.net.URL;
import java.net.URLConnection;

/**
 * @description
 *
 * @author xuys
 * 
 * @time 2015年3月24日 上午10:08:28
 **/
public class FileUtil {
	 public static String getMimeType(String fileUrl){  
	    try {
			String type = null;  
			URL u = new URL(fileUrl);  
			URLConnection uc = null;  
			uc = u.openConnection();  
			type = uc.getContentType();  
			
			System.out.println("file.type:" + type);
			
			return type;
		} catch (Exception e) {
			e.printStackTrace();
		}  
	    return null;
	 }  
	 
	 public static void main(String[] args) {
		 String filePath = "file://D://rush.png";
		 
		 String result = getMimeType(filePath);
		 System.out.println("file.type:" + result);
	}
}
