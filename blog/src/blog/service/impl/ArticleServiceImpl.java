package blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.mapper.ArticleMapper;
import blog.pojo.Article;
import blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	ArticleMapper articleMapper;
	
	public List<Article> list(){
		return articleMapper.list();
	}

	public List<Article> listArticle(Long id){
		return articleMapper.listArticle(id);
	}
	@Transactional
	public void addArticle(Article article) {
		articleMapper.addArticle(article);
	}
}
