package blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.mapper.ArticleMapper;
import blog.mapper.CategoryMapper;
import blog.pojo.Article;
import blog.pojo.Category;
import blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	ArticleMapper articleMapper;
	
	public List<Category> list() {
		return categoryMapper.list();
	}

	public void addCategory(String categoryName) {
		categoryMapper.addCategory(categoryName);
	}
	
	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}
	public void deleteCategory(Category category) {
		categoryMapper.deleteCategory(category);
	}
}
