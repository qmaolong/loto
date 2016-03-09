package com.wx.entity.message.resp.reply;

import com.wx.entity.message.resp.reply.BaseMessage;

public class MediaMessage extends BaseMessage {
	private String mediaId;

	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
