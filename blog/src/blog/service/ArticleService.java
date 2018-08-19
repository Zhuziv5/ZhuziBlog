package blog.service;

import java.util.List;

import blog.pojo.Article;
import blog.pojo.Category;


public interface ArticleService {
	List<Article> list();
	List<Article> listArticle(Long id);
	String showArticle(Article article);
	void addArticle(Article article,Category category);
	void deleteArticle(Article article,Category category);
	void updateArticle(Article article,Category category);
}
