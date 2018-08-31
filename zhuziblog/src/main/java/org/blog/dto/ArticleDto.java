package org.blog.dto;

import java.util.Date;

public class ArticleDto {
	// tbl_article_info基础字段
	private Long id; // 主键
	private String title; // 文章标题
	private String summary; // 文章简介
	private Integer traffic; // 文章浏览量
	private Date createBy; // 文章创建时间

	// tbl_article_content基础字段
	private Long articleContentId; // ArticleContent表主键
	private String content; // 文章内容

	// tbl_category_info基础字段
	private Long categoryId; // 分类ID
	private String categoryName; // 分类名称
	private Byte categoryNumber; // 分类对应的数量

	// tbl_article_category基础字段
	private Long articleCategoryId; // ArticleCategory表主键

	// tbl_article_picture基础字段
	private Long articlePictureId; // ArticlePicture表主键
	private String pictureUrl; // 文章题图url

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}

	public Long getArticleContentId() {
		return articleContentId;
	}

	public void setArticleContentId(Long articleContentId) {
		this.articleContentId = articleContentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Byte getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(Byte categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public Long getArticleCategoryId() {
		return articleCategoryId;
	}

	public void setArticleCategoryId(Long articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}

	public Long getArticlePictureId() {
		return articlePictureId;
	}

	public void setArticlePictureId(Long articlePictureId) {
		this.articlePictureId = articlePictureId;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
