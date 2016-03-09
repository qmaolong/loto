package com.wx.entity.message.resp.reply;

public class MusicMessage extends BaseMessage {
	private String title;
	private String description;
	private String musicUrl;
	private String hQMusicUrl;
	private String thumbMediaId;

	public String getTitle() {
		/* 36 */return this.title;
	}

	public void setTitle(String title) {
		/* 40 */this.title = title;
	}

	public String getDescription() {
		/* 44 */return this.description;
	}

	public void setDescription(String description) {
		/* 48 */this.description = description;
	}

	public String getMusicUrl() {
		/* 52 */return this.musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		/* 56 */this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		/* 60 */return this.hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		/* 64 */this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		/* 68 */return this.thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public MusicMessage(String title, String description, String musicUrl,
			String hQMusicUrl, String thumbMediaId) {
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hQMusicUrl = hQMusicUrl;
		this.thumbMediaId = thumbMediaId;
	}

	public MusicMessage() {
	}
}
