package org.blog.web;

import java.util.List;

import org.blog.entity.Article;
import org.blog.entity.Category;
import org.blog.service.ArticleService;
import org.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ArticleService articleService;
	// 对应分类页面
	@RequestMapping("/category")
	public String listCategory(Model model) {
		List<Category> listAllCategory = categoryService.list();
		// 放入转发参数
		model.addAttribute("listAllCategory", listAllCategory);
		return "category";
	}
	
	//对应分类管理页面
	@RequestMapping(value="/categoryManagement",method = RequestMethod.GET)
	public String  categoryManagement(Model model) {
		List<Category> listAllCategory = categoryService.list();
		model.addAttribute("listAllCategory", listAllCategory);
		return "categoryManagement";
	}
	
	//对应分类管理页面的删除某个分类
	@RequestMapping(value="/deleteCategory",method=RequestMethod.GET)
	public String deleteCategory(Article article,Category category) {
		categoryService.deleteCategory(category, article);
		return "redirect:categoryManagement";
	}
	
	//对应分类管理页面添加一个分类
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(Article article,Category category,Model model) {
		categoryService.addCategory(category);
		return "redirect:categoryManagement";
	}
	
	//对应分类管理页面修改一个分类
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(Category category) {
		categoryService.updateCategory(category);
		return "redirect:categoryManagement";
	}
	
	//对应分类页面点开分类下的所有文章
	@RequestMapping(value="/listArticle",method=RequestMethod.GET)
	public String listArticle(Category category,Model model) {
		List<Article> listArticle =articleService.listArticle(category);
		model.addAttribute("listArticle", listArticle);
		return "articleList";
	}
}
