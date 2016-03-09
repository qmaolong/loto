package com.wx.entity.menu;

import com.wx.entity.menu.Button;

public class ViewButton extends Button {
	private String type;
	private String url;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ViewButton(String type, String url) {
		this.type = type;
		this.url = url;
	}

	public ViewButton() {
	}
}
