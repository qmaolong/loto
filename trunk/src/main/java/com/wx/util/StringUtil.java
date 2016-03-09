package com.wx.util;

import java.security.MessageDigest;
import java.util.UUID;

public class StringUtil {
	public static boolean isEmpty(Object value) {
		return (value == null) || ("".equals(value));
	}

	public static boolean isNotEmpty(Object value) {
		return !isEmpty(value);
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.toUpperCase().replace("-", "");
	}

	public static String getMD5(String source) {
		if ((source == null) || (source == "")) {
			return null;
		}
		String str = null;
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source.getBytes());
			byte[] tmp = md.digest();
			char[] chstr = new char[32];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				chstr[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
				chstr[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			str = new String(chstr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}
}
