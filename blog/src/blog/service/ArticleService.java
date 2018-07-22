package blog.service;

import java.util.List;

import blog.pojo.Article;


public interface ArticleService {
	List<Article> list();
	List<Article> listArticle(Long id);
	void addArticle(Article article);
}
