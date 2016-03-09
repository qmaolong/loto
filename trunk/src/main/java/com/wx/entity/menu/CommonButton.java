package com.wx.entity.menu;

import com.wx.entity.menu.Button;

public class CommonButton extends Button {
	private String type;
	private String key;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public CommonButton(String type, String key) {
		this.type = type;
		this.key = key;
	}

	public CommonButton() {
	}
}
