package blog.mapper;

import java.util.List;

import blog.pojo.Article;

public interface ArticleMapper {
	void addArticle(Article article);
	void delete(Long id);
	void update(Article article);
	Article get(Long id);
	List<Article> list();
	List<Article> listArticle(Long id);
}
