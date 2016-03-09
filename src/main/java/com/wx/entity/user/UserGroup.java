package com.wx.entity.user;

public class UserGroup {
	private String id;
	private String name;
	private int count;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserGroup(String id, String name, int count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public UserGroup() {
	}
}
