/**
 * 对应文章表tbl_article_content和tbl_article_info
 */

package blog.pojo;

public class Article {
	//对应表tbl_article_content
	private Long id;
	private String content;
	//articleId在Category类中
	
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
	
	
}
