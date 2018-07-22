<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="index">我的小站</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a href="index">主页</a></li>
									<li class="active"><a href="category">分类</a></li>
									<li><a href="categoryManagement">管理</a></li>
									<li><a href="#">关于</a></li>
								</ul>
								<form class="form-search pull-right">
									<input class="input-medium search-query" type="text" />
									<button class="btn" type="submit">查找</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span1"></div>
					<div class="span10">
						<div class="row-fluid">
							<div class="span3"></div>
							<div class="span6">
								<h3>文章目录</h3>
								<c:forEach items="${cs}" var="c" varStatus="st">
									<a href="listOneCategoryArticle?id=${c.id}" class="list-group-item">${c.name}<span
										class="label label-default">${c.number }</span></a>
								</c:forEach>
							</div>
							<div class="span3"></div>
						</div>
					</div>
					<div class="span1"></div>
				</div>
			</div>
			<div class="span1"></div>
		</div>
	</div>
</body>
</html>