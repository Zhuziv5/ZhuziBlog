/**
 * 对应表tbl_category_info和tbl_article_category
 */

package blog.pojo;

public class Category {
	//对应表tbl_category_info
	private Long id;
	private String name;//分类名称
	private Integer number;//该分类下的文章数量
	
	//对应表tbl_article_category
	private Long categoryId;//分类id
	private Long articleId;//文章Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	
}
