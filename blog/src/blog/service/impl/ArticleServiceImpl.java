package blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import blog.mapper.ArticleMapper;
import blog.mapper.CategoryMapper;
import blog.pojo.Article;
import blog.pojo.Category;
import blog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	CategoryMapper categoryMapper;

	public List<Article> list() {
		return articleMapper.list();
	}

	public List<Article> listArticle(Long id) {
		return articleMapper.listArticle(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void addArticle(Article article, Category category) {
		// 增加至tbl_article_info表中title和summary记录
		articleMapper.addArticleInfo(article);
		// getArticleLastInsertId（）获取上一步插入操作产生的自增长的id，将其作为article_id传入article中
		article.setArticle_id(articleMapper.getArticleLastInsertId());
		// 将content和article_id插入到表tbl_article_content中
		articleMapper.addArticleContent(article);
		// 表ttbl_article_category里的article_id和category_id也要及时更新，因为他们一一对应
		// 这里有多个参数，来自两个不同对象，所以要把多个参数放在map里，然后把这个Map对象作为参数传递进去
//		article_id=article.getArticle_id();
//		category_id=categoryMapper.getCategoryIdByName(category);
		Map<String, Object> params = new HashMap<>();
		params.put("article_id", article.getArticle_id());
		params.put("category_id", categoryMapper.getCategoryIdByName(category));
		articleMapper.addArticleAndCategory(params);
		// 增加一篇文章后，对应 的分类下的tbl_category_number数量要加1
		categoryMapper.increaseCategoryNumber(category);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void deleteArticle(Article article, Category category) {
		// tbl_article_content根据模态窗传来的表tbl_article_info的article_id,删除表中对应行
		articleMapper.deleteArticleContent(article);
		// article_id传给id,到tbl_article_info表删除行
		article.setId(article.getArticle_id());
		articleMapper.deleteArticleInfo(article);
		// tbl_category_info, article_id找category_id，category_id传id,使number减一
		article.setCategory_id(articleMapper.getCategory_idByArticle_id(article));
		category.setId(article.getCategory_id());
		categoryMapper.decreaseCategoryNumber(category);
		// tbl_article_category,由article_id删除行
		articleMapper.deleteArticleCategory(article);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void updateArticle(Article article,Category category) {
		//1.tbl_articles_content,由article_id更新content
		articleMapper.updateArticleContent(article);
		//2.tbl_article_info，将article_id传给id,更新title和summary
		article.setId(article.getArticle_id());
		articleMapper.updateArticleInfo(article);
		//3.tbl_article_category,由article_id更新对应的category_id
		article.setCategory_id(categoryMapper.getCategoryIdByName(category));
		articleMapper.updateArticleCategory(article);
		//4.tbl_category_info
		//先判断是否选择了不同的分类,tbl_category_info
		//	1取到分类id1,select category_id from tbl_article_category where article_id=#{....}
		//	对应函数id1=articleMapper.getCategory_idByArticle_id(article)
		//	2取到分类id2，select id from tbl_category_info where name=#{name}
		//	对应函数id2=categoryMapper.getCategoryIdByName(category);
		//比较id1和id2，相等则表tbl_category_info不用更新
		System.out.println(article.getArticle_id());
		Long id1=articleMapper.getCategory_idByArticle_id(article);
		System.out.println(id1);
		Long id2=article.getCategory_id();
		System.out.println(id2);
		if(id1.equals(id2)) {
//		if((articleMapper.getCategory_idByArticle_id(article)).equals(categoryMapper.getCategoryIdByName(category))) {
		//不相等，则将新分类number加一，原分类减一
		}else {
			//新分类加一
			categoryMapper.increaseCategoryNumber(category);
			//原分类减一
			category.setId(articleMapper.getCategory_idByArticle_id(article));
			categoryMapper.decreaseCategoryNumber(category);
		}
	}

	public String showArticle(Article article) {
		return articleMapper.showArticle(article);
	}
}
