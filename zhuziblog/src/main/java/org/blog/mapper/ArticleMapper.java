package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.Article;
import org.blog.entity.Category;

public interface ArticleMapper {
	void addArticleInfo(Article article);

	void addArticleContent(Article article);

	void addArticleAndCategory(Map<String, Object> params);

	void update(Article article);

	void updateArticleContent(Article article);

	void updateArticleInfo(Article article);

	void updateArticleCategory(Article article);

	void updateArticle_idByCategory_id(Article article);

	void deleteArticleInfo(Article article);

	void deleteArticleContent(Article article);

	void deleteArticleCategory(Article article);

	Long getCategory_idByArticle_id(Article article);

	Article get(Long id);

	List<Article> list();

	List<Article> listArticle(Category category);

	Long getArticleLastInsertId();

	String showArticle(Long article_id);

}
