package org.blog.service;

import java.util.List;

import org.blog.entity.Article;
import org.blog.entity.Category;


public interface CategoryService {
	List<Category> list();
	void deleteCategory(Category category,Article article);
	void addCategory(Category category);
	void updateCategory(Category category);
}
