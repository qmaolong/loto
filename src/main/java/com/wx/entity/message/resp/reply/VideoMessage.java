package com.wx.entity.message.resp.reply;

public class VideoMessage extends MediaMessage {
	private String title;
	private String description;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VideoMessage(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public VideoMessage() {
	}
}
