<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="/WEB-INF/common/tag.jsp"%>
<html>
<head>
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

					<!-- 显示所有分类 -->
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2 class="text-center">文章目录</h2>
						<c:forEach items="${listAllCategory}" var="c" varStatus="st">
							<a href="listArticle?id=${c.id}"
								class="list-group-item">${c.name}
								<span class="badge label label-default">${c.number }</span></a>
						</c:forEach>
					</div>
					<div class="col-md-3"></div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
<br><br><br><br><br>
</body>
</html>