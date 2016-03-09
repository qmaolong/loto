package com.wx.entity.customer;

import com.wx.entity.customer.CustomerBaseMessage;
import com.wx.entity.customer.Text;

public class TextMessage extends CustomerBaseMessage {
	private Text text;

	public Text getText() {
		return this.text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public TextMessage(Text text) {
		this.text = text;
	}

	public TextMessage() {
	}
}
