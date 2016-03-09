package com.wx.entity.menu;

import com.wx.entity.menu.Button;

public class Menu {
	private Button[] button;

	public Button[] getButton() {
		return this.button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public Menu(Button[] button) {
		this.button = button;
	}

	public Menu() {
	}
}
