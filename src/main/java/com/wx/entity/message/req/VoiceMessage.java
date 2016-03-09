package com.wx.entity.message.req;

import com.wx.entity.message.req.BaseMessage;

public class VoiceMessage extends BaseMessage {
	private String Format;

	public String getFormat() {
		return this.Format;
	}

	public void setFormat(String format) {
		this.Format = format;
	}

	public VoiceMessage(String format) {
		this.Format = format;
	}
}
