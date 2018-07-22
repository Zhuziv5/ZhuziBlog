/**
 * 
 * 
 */

package blog.mapper;

import java.util.List;

import blog.pojo.Category;

public interface CategoryMapper {
	void addCategory(String categoryName);
	void deleteCategory(Category category);
	void updateCategory(Category category);
	Category get(Long id);
	List<Category> list();
}
