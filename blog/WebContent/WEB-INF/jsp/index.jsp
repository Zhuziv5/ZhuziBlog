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
			<div class="span12">
				<div class="row-fluid">
					<div class="span1"></div>
					<div class="span10">
						<div class="navbar">
							<div class="navbar-inner">
								<div class="container-fluid">
									<a class="btn btn-navbar"
										data-target=".navbar-responsive-collapse"
										data-toggle="collapse"></a> <a class="brand" href="#">我的小站</a>
									<div class="nav-collapse collapse navbar-responsive-collapse">
										<ul class="nav">
											<li class="active"><a href="index">主页</a></li>
											<li><a href="category">分类</a></li>
											<li><a href="categoryManagement">管理</a></li>
											<li><a href="#">关于</a></li>
										</ul>
										<form class="form-search pull-right">
											<input class="input-medium search-query" type="text" />
											<button type="submit" class="btn">查找</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<div class="row-fluid">
									<div class="span1"></div>
									<div class="span10">
										<h2>全部文章</h2>
										<c:forEach items="${as}" var="c" varStatus="st">
											<div class="col-md-3">
												<h2>${c.title}</h2>
												<p>${c.summary}</p>
												<p>
													<a class="btn" href="#">浏览全文 »</a>
												</p>
											</div>
										</c:forEach>
									</div>
									<div class="span1"></div>
								</div>
							</div>
						</div>
						<div class="pagination pagination-centered">
							<ul>
								<li><a href="?start=0">首页</a></li>
								<li><a
									href="?start=${(page.start-page.count)>0?(page.start-page.count-1):0}">上一页</a></li>
								<li><a
									href="?start=${(page.start+page.count)<page.last?(page.start+page.count):page.last}">下一页</a></li>
								<li><a href="?start=${page.last}">末 页</a></li>
							</ul>
						</div>
					</div>
					<div class="span1"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>