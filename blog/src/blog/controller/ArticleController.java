package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import blog.pojo.Article;
import blog.pojo.Category;
import blog.service.ArticleService;
import blog.service.CategoryService;
import blog.util.Page;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@Autowired
	CategoryService categoryService;
	//对应主页，即显示所有博文
	@RequestMapping("index")
	public ModelAndView listArticle(Page page) {
		ModelAndView mav=new ModelAndView();
		PageHelper.offsetPage(page.getStart(),9);
		List<Article>  as=articleService.list();
		
		int total = (int) new PageInfo<>(as).getTotal();
		page.caculateLast(total);
		//放入转发参数
		mav.addObject("as", as);
		//放入jsp路径
		mav.setViewName("index");
		return mav;
	}
	//对应管理页面-博文管理页面
	@RequestMapping("articleManagement")
	public ModelAndView articleManagement(Page page) {
		ModelAndView mav=new ModelAndView();
		PageHelper.offsetPage(page.getStart(),4);
		List<Article>  as=articleService.list();
		List<Category> cl=categoryService.list();
		int total = (int) new PageInfo<>(as).getTotal();
		page.caculateLast(total);
		
		//放入转发参数
		mav.addObject("as", as);
		mav.addObject("cl", cl);
		//放入jsp路径
		mav.setViewName("articleManagement");
		return mav;
	}
	//对应管理页面-博文管理-添加文章功能
	@RequestMapping("addArticle")
	public ModelAndView addArticle(Article article) {
		articleService.addArticle(article);
		return new ModelAndView("articleManagement","article",article);
	}
}
