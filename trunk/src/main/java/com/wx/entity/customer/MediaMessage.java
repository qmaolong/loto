package com.wx.entity.customer;

import com.wx.entity.customer.CustomerBaseMessage;
import com.wx.entity.customer.Media;

public class MediaMessage extends CustomerBaseMessage {
	private Media media;

	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public MediaMessage(Media media) {
		this.media = media;
	}

	public MediaMessage() {
	}
}
