package com.wx.entity.customer;

import com.wx.entity.customer.CustomerBaseMessage;
import com.wx.entity.customer.Music;

public class MusicMessage extends CustomerBaseMessage {
	private Music music;

	public Music getMusic() {
		return this.music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public MusicMessage(Music music) {
		this.music = music;
	}

	public MusicMessage() {
	}
}
