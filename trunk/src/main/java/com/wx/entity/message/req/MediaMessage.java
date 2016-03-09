package com.wx.entity.message.req;

import com.wx.entity.message.req.BaseMessage;

public class MediaMessage extends BaseMessage {
	private String mediaId;

	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
