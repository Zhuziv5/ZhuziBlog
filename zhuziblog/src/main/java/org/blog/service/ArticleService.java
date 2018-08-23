package org.blog.service;

import java.util.List;

import org.blog.entity.Article;
import org.blog.entity.Category;


public interface ArticleService {
	List<Article> list();
	List<Article> listArticle(Category category);
	void deleteArticle(Article article,Category category);
	void addArticle(Article article,Category category);
	void updateArticle(Article article,Category category);
	String showArticle(Article article);

}
