package com.wx.entity;

public class AccessToken {
	private String token;
	private int expiresIn;

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpiresIn() {
		return this.expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public AccessToken(String token, int expiresIn) {
		this.token = token;
		this.expiresIn = expiresIn;
	}

	public AccessToken() {
	}
}
