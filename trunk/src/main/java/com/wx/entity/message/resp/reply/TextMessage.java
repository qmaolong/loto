package com.wx.entity.message.resp.reply;

import com.wx.entity.message.resp.reply.BaseMessage;

public class TextMessage extends BaseMessage {
	private String Content;

	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	public TextMessage(String content) {
		this.Content = content;
	}

	public TextMessage() {
	}
}
