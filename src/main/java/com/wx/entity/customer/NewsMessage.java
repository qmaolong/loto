package com.wx.entity.customer;

import com.wx.entity.customer.CustomerBaseMessage;
import com.wx.entity.customer.News;

public class NewsMessage extends CustomerBaseMessage {
	private News news;

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public NewsMessage(News news) {
		this.news = news;
	}

	public NewsMessage() {
	}
}
