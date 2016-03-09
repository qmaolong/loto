package com.wx.entity.message.req;

import com.wx.entity.message.req.MediaMessage;

public class ImageMessage extends MediaMessage {
	private String picUrl;

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public ImageMessage(String picUrl) {
		this.picUrl = picUrl;
	}
}
