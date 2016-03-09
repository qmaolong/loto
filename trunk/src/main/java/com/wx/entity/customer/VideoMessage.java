package com.wx.entity.customer;

import com.wx.entity.customer.MediaMessage;
import com.wx.entity.customer.Video;

public class VideoMessage extends MediaMessage {
	private Video video;

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public VideoMessage(Video video) {
		this.video = video;
	}

	public VideoMessage() {
	}
}
