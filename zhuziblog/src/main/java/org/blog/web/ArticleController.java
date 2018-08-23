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

@Controller
@RequestMapping("/blogs")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@Autowired
	CategoryService categoryService;

	// 对应主页，即显示所有博文
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String listArticle(Model model) {
		List<Article> listAllArticle = articleService.list();

		model.addAttribute("listAllArticle", listAllArticle);

		return "article";
	}

	// 对应管理页面-博文管理页面
	@RequestMapping(value = "/articleManagement", method = RequestMethod.GET)
	public String articleManagement(Article article,Model model) {
		List<Article> listAllArticle = articleService.list();
		List<Category> listAllCategory = categoryService.list();

		// 放入转发参数
		model.addAttribute("listAllArticle", listAllArticle);
		model.addAttribute("listAllCategory", listAllCategory);

		return "articleManagement";
	}

	// 对应管理页面-博文管理-删除文章功能
	@RequestMapping(value = "/deleteArticle", method = RequestMethod.GET)
	public String deleteArticle(Article article, Category category, Model model) {
		articleService.deleteArticle(article, category);
		return "redirect:articleManagement";
	}
	
	@RequestMapping(value="/addArticle",method = RequestMethod.POST)
	public String addArticle(Article article,Category category,Model model) {
		articleService.addArticle(article, category);
		return "redirect:articleManagement";		
	}
	
	@RequestMapping(value="updateArticle",method = RequestMethod.POST)
	public String updateArticle(Article article,Category category,Model model) {
		articleService.updateArticle(article,category);
		return "redirect:articleManagement";
		
	}
	
}
