package com.wx.entity;

public class QRcode {
	private String expireSeconds;
	private String actionName;
	private String actionInfo;
	private String sceneId;
	private String ticket;

	public String getExpireSeconds() {
		return this.expireSeconds;
	}

	public void setExpireSeconds(String expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionInfo() {
		return this.actionInfo;
	}

	public void setActionInfo(String actionInfo) {
		this.actionInfo = actionInfo;
	}

	public String getSceneId() {
		return this.sceneId;
	}

	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public QRcode(String expireSeconds, String actionName, String actionInfo,
			String sceneId, String ticket) {
		this.expireSeconds = expireSeconds;
		this.actionName = actionName;
		this.actionInfo = actionInfo;
		this.sceneId = sceneId;
		this.ticket = ticket;
	}

	public QRcode() {
	}
}
