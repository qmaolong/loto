package com.wx.entity.user;

import java.util.Date;

public class UserWeiXin {
	private Integer subscribe;
	private String openid;
	private String nickname;
	private Integer sex;
	private String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private Date subscribe_time;
	private String privilege;

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public Integer getSubscribe() {
		return this.subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Date getSubscribe_time() {
		return this.subscribe_time;
	}

	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	public UserWeiXin(Integer subscribe, String openid, String nickname,
			Integer sex, String city, String country, String province,
			String language, String headimgurl, Date subscribe_time,
			String privilege) {
		this.subscribe = subscribe;
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headimgurl = headimgurl;
		this.subscribe_time = subscribe_time;
		this.privilege = privilege;
	}

	public UserWeiXin() {
	}
}
