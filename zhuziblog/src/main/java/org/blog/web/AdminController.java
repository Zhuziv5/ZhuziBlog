package org.blog.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blog.entity.Article;
import org.blog.entity.Category;
import org.blog.entity.User;
import org.blog.service.ArticleService;
import org.blog.service.CategoryService;
import org.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	// 后台登录的账号和密码
	private static String username = "xxz";
	private static String password = "123456";

	@Autowired
	ArticleService articleService;

	@Autowired
	CategoryService categoryService;

	// 后台登录操作
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("进入到controller!");
		if(user.getUsername().equals(username)&&user.getPassword().equals(password)) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/zhuziblog/admin/articleManagement");
		}else {
			response.sendRedirect("error.html");
		}
		return null;
	}

	// 对应管理页面-博文管理页面
	@RequestMapping(value = "/articleManagement", method = RequestMethod.GET)
	public String articleManagement(Article article, Model model,Page page) {
		PageHelper.offsetPage(page.getStart(), 5);
		List<Article> listAllArticle = articleService.list();
		List<Category> listAllCategory = categoryService.list();
		int total  = (int) new PageInfo<>(listAllArticle).getTotal();
		page.calculateLast(total);
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

	// 对应管理页面-博文管理-增加文章功能
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String addArticle(Article article, Category category, Model model) {
		articleService.addArticle(article, category);
		return "redirect:articleManagement";
	}

	// 对应管理页面-博文管理-更新文章功能
	@RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
	public String updateArticle(Article article, Category category, Model model) {
		articleService.updateArticle(article, category);
		return "redirect:articleManagement";
	}

	// 对应分类管理页面
	@RequestMapping(value = "/categoryManagement", method = RequestMethod.GET)
	public String categoryManagement(Model model,Page page) {
		PageHelper.offsetPage(page.getStart(), 5);
		List<Category> listAllCategory = categoryService.list();
		int total  = (int) new PageInfo<>(listAllCategory).getTotal();
		page.calculateLast(total);
		model.addAttribute("listAllCategory", listAllCategory);
		return "categoryManagement";
	}

	// 对应分类管理页面的删除某个分类
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(Article article, Category category) {
		categoryService.deleteCategory(category, article);
		return "redirect:categoryManagement";
	}

	// 对应分类管理页面添加一个分类
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(Article article, Category category, Model model) {
		categoryService.addCategory(category);
		return "redirect:categoryManagement";
	}

	// 对应分类管理页面修改一个分类
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(Category category) {
		categoryService.updateCategory(category);
		return "redirect:categoryManagement";
	}

	
}
