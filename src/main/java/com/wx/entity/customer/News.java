package com.wx.entity.customer;

import java.util.List;

public class News {
	private List<Article> Articles;

	public List<Article> getArticles() {
		return this.Articles;
	}

	public void setArticles(List<Article> articles) {
		this.Articles = articles;
	}

	public News(List<Article> articles) {
		this.Articles = articles;
	}

	public News() {
	}
}
