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
						<h2>文章内容</h2>
						<p>${articleContent }</p>
				</div>
			</div>
		</div>

</body>
</html>