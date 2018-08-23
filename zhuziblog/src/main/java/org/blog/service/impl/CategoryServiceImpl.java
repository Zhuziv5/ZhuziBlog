package org.blog.service.impl;

import java.util.List;

import org.blog.entity.Article;
import org.blog.entity.Category;
import org.blog.mapper.ArticleMapper;
import org.blog.mapper.CategoryMapper;
import org.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	ArticleMapper articleMapper;
	
	public List<Category> list() {
			return categoryMapper.list();
		}
	public void addCategory(Category category) {
		categoryMapper.addCategory(category);
	}
	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void deleteCategory(Category category,Article article) {
		//由原分类的name取id传给category_id,由category_id取其对应的那些article_id
		article.setCategory_id(categoryMapper.getCategoryIdByName(category));
		//一长串的查询语句就是在表tbl_article_category中，将原文章article_id对应到其他分类对应的category_id
		articleMapper.updateArticle_idByCategory_id(article);
		//删除表tbl_category_info对应的分类行,将其他分类的number加上n
		categoryMapper.updateOtherCategoryNumber(category);
		categoryMapper.deleteCategory(category);
	}
	
	
}
