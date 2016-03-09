package com.wx.entity;

public class AccessTokenOAuth {
	private String accessToken;
	private int expiresIn;
	private String refreshToken;
	private String openid;
	private String scope;

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return this.expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public AccessTokenOAuth(String accessToken, int expiresIn,
			String refreshToken, String openid, String scope) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.refreshToken = refreshToken;
		this.openid = openid;
		this.scope = scope;
	}

	public AccessTokenOAuth() {
	}
}
