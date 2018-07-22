package blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ArticleService articleService;
	
	//对应分类页面
	@RequestMapping("category")
	public ModelAndView listCategory() {
		ModelAndView mav=new ModelAndView();
		List<Category> cs=categoryService.list();
		//放入转发参数
		mav.addObject("cs", cs);
		//放入jsp路径
		mav.setViewName("category");
		return mav;
	}
	
	//对应分类页面-点击任一文章目录的下级页面（用来展示这一分类下的所有文章）
	@RequestMapping("listOneCategoryArticle")
	public ModelAndView listOneCategoryArticle(HttpServletRequest request,Page page) {
		//从href获得的id即tbl_category_info的主键id,要用request.getParameter
		Long id=Long.parseLong(request.getParameter("id"));
		//pagehelper插件要在sql语句前
		PageHelper.offsetPage(page.getStart(),9);
		//由tbl_category_id从表tbl_article_category中查对应的
		List<Article> at=articleService.listArticle(id);
		ModelAndView mav=new ModelAndView();
		
		int total = (int) new PageInfo<>(at).getTotal();
		page.caculateLast(total);
		//放入转发参数
		mav.addObject("at",at);
		//放入jsp路径
		mav.setViewName("listOneCategoryArticle");
		return mav;
	}
	//对应管理页面-分类管理（事实上是所有点击管理的动作都会调到分类管理页面）
	@RequestMapping("categoryManagement")
	public ModelAndView categoryManagement() {
		ModelAndView mav=new ModelAndView();
		List<Category> cl=categoryService.list();
		
		//放入转发参数
		mav.addObject("cl", cl);
		//放入jsp路径
		mav.setViewName("categoryManagement");
		return mav;
	}
	//对应管理页面-分类管理-新增分类功能
	@RequestMapping("addCategory")
	public ModelAndView addCategory(HttpServletRequest request) {
		String newCategoryName=request.getParameter("newCategoryName");
		ModelAndView mav=new ModelAndView();
		try {
		categoryService.addCategory(newCategoryName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:categoryManagement");
		return mav;
	}
	//对应管理页面-分类页面-修改分类名称
	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category c) {
		ModelAndView mav=new ModelAndView();
		try {
			categoryService.updateCategory(c);
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("redirect:categoryManagement");
			return mav;
	}
	//对应管理页面-分类页面-删除分类
	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category) {
		categoryService.deleteCategory(category);
		return new ModelAndView("redirect:categoryManagement","category",category);
	}
}
