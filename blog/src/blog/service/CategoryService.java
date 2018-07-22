package blog.service;

import java.util.List;

import blog.pojo.Article;
import blog.pojo.Category;

public interface CategoryService {
	List<Category> list();
	void addCategory(String categoryName);
	void updateCategory(Category category);
	void deleteCategory(Category category);
}
