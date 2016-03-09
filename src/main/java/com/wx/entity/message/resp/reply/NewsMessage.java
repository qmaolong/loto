package com.wx.entity.message.resp.reply;

import java.util.List;

public class NewsMessage extends BaseMessage {
	private int ArticleCount;
	private List<Article> Articles;

	public int getArticleCount() {
		return this.ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		this.ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return this.Articles;
	}

	public void setArticles(List<Article> articles) {
		this.Articles = articles;
	}

	public NewsMessage(int articleCount, List<Article> articles) {
		this.ArticleCount = articleCount;
		this.Articles = articles;
	}

	public NewsMessage() {
	}
}
