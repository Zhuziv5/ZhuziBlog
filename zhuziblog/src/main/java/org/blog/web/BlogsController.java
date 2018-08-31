package org.blog.web;

import java.util.List;

import org.blog.entity.Article;
import org.blog.entity.Category;
import org.blog.service.ArticleService;
import org.blog.service.CategoryService;
import org.blog.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
	@Autowired
	ArticleService articleService;

	@Autowired
	CategoryService categoryService;
	
	// 对应主页，即显示所有博文
		@RequestMapping(value = "/article", method = RequestMethod.GET)
		public String listArticle(Model model,Page page) {
			PageHelper.offsetPage(page.getStart(), 6);
			List<Article> listAllArticle = articleService.list();
			int total  = (int) new PageInfo<>(listAllArticle).getTotal();
			page.calculateLast(total);
			model.addAttribute("listAllArticle", listAllArticle);

			return "article";
		}
		
		//对应显示详细博文页功能
		@RequestMapping(value="/showArticle",method=RequestMethod.GET)
		public String showArticle(@RequestParam(value="id") Long article_id,Article article,Model model) {
//			article_id = Long.parseLong(request.getParameter("id"));
			model.addAttribute("articleContent", articleService.showArticle(article_id,article));
			return "showArticle";
		}
		
		// 对应分类页面
		@RequestMapping("/category")
		public String listCategory(Model model) {
			List<Category> listAllCategory = categoryService.list();
			// 放入转发参数
			model.addAttribute("listAllCategory", listAllCategory);
			return "category";
		}
		
		//对应分类页面点开分类下的所有文章
		@RequestMapping(value="/listArticle",method=RequestMethod.GET)
		public String listArticle(Category category,Model model,Page page) {
			List<Article> listArticle =articleService.listArticle(category);
			model.addAttribute("listArticle", listArticle);
			return "articleList";
		}
}
