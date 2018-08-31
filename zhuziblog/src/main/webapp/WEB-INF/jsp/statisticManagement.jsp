<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="/WEB-INF/common/tag.jsp"%>
<html>
<head>
<title>我的博客</title>
<%@include file="/WEB-INF/common/head.jsp"%>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
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
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="row-fluid">
						<div class="col-md-2">
							<ul class="nav nav-stacked nav-pills">
								<li class="active"><a href="statisticManagement">数据统计</a></li>
								<li><a href="categoryManagement">分类管理</a></li>
								<li><a href="articleManagement">博文管理</a></li>
							</ul>
						</div>
						<div class="col-md-10">
							<div id="page-wrapper">
								<div class="row">
									<div class="col-lg-12">
										<h1 class="page-header">数据统计</h1>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<div class="row">
													<div class="col-xs-3">
														<i class="fa fa-eye fa-5x "></i>
													</div>
													<div class="col-xs-9 text-center fa-2x ">
														<div class="huge">TODO</div>
														<div>Visits!</div>
													</div>
												</div>
											</div>
											<div class="panel-footer text-center">
												<a href="statisticManagement">view details</a>
											</div>
										</div>
									</div>

									<div class="col-lg-6 col-md-6">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<div class="row">
													<div class="col-xs-3">
														<i class="fa fa-tasks fa-5x "></i>
													</div>
													<div class="col-xs-9 text-center fa-2x">
														<div class="huge">TODO</div>
														<div>Logs!</div>
													</div>
												</div>
											</div>
											<div class="panel-footer text-center">
												<a href="statisticLogManagement">view details</a>
											</div>
										</div>
									</div>



								</div>
							</div>




							<div class="panel panel-default">
								<div class="panel-heading">访问统计</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>ID</th>
													<th>访问IP</th>
													<th>访问时间</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listAllSysView}" var="c" varStatus="st">
													<tr>
														<td>${c.id }</td>
														<td>${c.ip }</td>
														<td>${c.createBy }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination pagination-centered pagination-lg">
											<li><a href="?start=0">首 页</a></li>
											<li><a href="?start=${page.start-page.count }">上一页</a>
											<li><a href="?start=${page.start+page.count }">下一页</a>
											<li><a href="?start=${page.last }">末页</a>
										</ul>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>
</body>
</html>