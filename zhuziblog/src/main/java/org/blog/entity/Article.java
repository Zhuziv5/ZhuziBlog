/**
 * 对应文章表tbl_article_content和tbl_article_info
 */

package org.blog.entity;

public class Article {
	//对应表tbl_article_content
	private Long id;
	private String content;
	
	//对应表tbl_article_category
	private Long category_id;//分类id
	private Long article_id;//文章Id,在表tbl_article_content和表tbl_article_category中都有
		
	//对应tbl_article_info
	private String title;
	private String summary;
	private Integer traffic;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getTraffic() {
		return traffic;
	}
	public void setTraffic(Integer traffic) {
		this.traffic = traffic;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
	
}
