<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="/WEB-INF/common/tag.jsp"%>
<html>
<head>
<style>
.line-limit-length {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	<!--
	(
	这里是行数
	你可以控制你想在第几行末尾多余的显示省略号，之前的文本正常显示)
	-->
}
</style>
<title>我的博客</title>
<%@include file="/WEB-INF/common/head.jsp"%>
</head>
<body>
	<!-- 将导航栏提取出来作为公共资源 -->
	<%@ include file="/WEB-INF/common/navigationbar.jsp"%>
	<div>
		<img
			src="http://image.youzhan.org/d/dd/2de797545de56274f03a5920eb3a1.jpg"
			class="img-responsive img-thumbnail" />
	</div>

	<div class="container-fluid">
		<div class="col-md-12">
			<div class="row-fluid">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<!-- 展示所有文章 -->
					<h2 class="text-center">全部文章</h2>
					<ul class="thumbnails">
						<c:forEach items="${listAllArticle}" var="c" varStatus="st">
							<li class="col-md-4 col-sm-12 list-unstyled">
								<div class="thumbnail">
									<div class="caption">
										<h4>${c.title}</h4>
										<p class="line-limit-length">${c.summary}</p>
										<p>
											<a class="btn btn-primary" href="showArticle?id=${c.id}">浏览全文</a>
										</p>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="col-md-2"></div>

			</div>

		</div>
	</div>
	<ul class="pager">
		<li><a href="?start=0">首 页</a></li>
		<li><a href="?start=${page.start-page.count }">上一页</a>
		<li><a href="?start=${page.start+page.count }">下一页</a>
		<li><a href="?start=${page.last }">末页</a>
	</ul>
</body>
</html>