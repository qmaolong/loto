package com.wx.entity.message.req;

import com.wx.entity.message.req.BaseMessage;

public class VideoMessage extends BaseMessage {
	private String thumbMediaId;

	public String getThumbMediaId() {
		return this.thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public VideoMessage(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
