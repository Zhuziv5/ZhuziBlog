/**
 * 
 * 
 */

package org.blog.mapper;

import java.util.List;

import org.blog.entity.Category;

public interface CategoryMapper {
	void addCategory(Category category);

	void deleteCategory(Category category);

	void updateCategory(Category category);// 改名字

	void updateOtherCategoryNumber(Category category);// 将删除的分类下的number转移到其他分类下

	void increaseCategoryNumber(Category category);// 增加分类下的数量1,where条件用的是name

	void decreaseCategoryNumber(Category category);// 减少分类下的数量1,where条件用的是id

	Category get(Long id);

	List<Category> list();

	Long getCategoryIdByName(Category category);
}
