<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.slim.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid" id="LG">
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="#">我的小站</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a href="index">主页</a></li>
									<li><a href="category">分类</a></li>
									<li class="active"><a href="categoryManagement">管理</a></li>
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
					<div class="span3">
						<ul class="nav nav-stacked nav-pills">
							<li><a href="#">数据统计</a></li>
							<li class="active"><a href="categoryManagement">分类管理</a></li>
							<li><a href="articleManagement">博文管理</a></li>
						</ul>
					</div>
					<div class="span9">
						<table class="table">
							<thead>
								<tr>
									<th>分类ID</th>
									<th>分类名称</th>
									<th>创建时间</th>
									<th>文章数量</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${cl}" var="c" varStatus="st">
									<tr>
										<td>${c.id }</td>
										<td>${c.name }</td>
										<td>时间待完成</td>
										<td>${c.number }</td>
										<td>
											<div class="btn-group">
												<button type="button"
													class="btn btn-primary btn-lg btn-success"
													data-toggle="modal" data-target="#myModal${c.id }">编辑</button>
												<form action="deleteCategory">
													<button type="submit" name="name" value="${c.name }"
														class="btn btn-primary btn-lg btn-danger">删除</button>
												</form>
											</div>
											<div class="modal fade" id="myModal${c.id }" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myModalLabel">修改分类名称</h4>
														</div>
														<form action="updateCategory" role="form">
															<div class="modal-body">
																<div class="form-group">
																	<label class=" control-label"><b>分类名称</b></label>
																	<div>
																		<p class="form-control-static">${c.name}</p>
																	</div>
																</div>
																<div class="form-group">
																	<label for="inputtext" class="control-label"><b>修改名称</b></label>
																	<div>
																		<input type="text" class="form-control" id="inputtext"
																			name="name" placeholder="不要输入重复分类名称"> <input
																			type="hidden" name="id" value=${c.id }>
																	</div>
																</div>
															</div>
															<div class="modal-footer">
																<button type="submit" class="btn btn-primary">
																	确认修改</button>
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">取消</button>
															</div>
														</form>

													</div>
												</div>
											</div>

										</td>
									</tr>
								</c:forEach>


							</tbody>
						</table>
						<div class="row-fluid">
							<div class="span6">
								<form action="addCategory">
									<fieldset>
										<legend>新增分类</legend>
										<label>新增分类名</label><input type="text" name="name" /> <span
											class="help-block">注意：不要增加重复分类</span>
										<button type="submit" class="btn">确定</button>
									</fieldset>
								</form>
							</div>

							<div class="span6"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="span1"></div>
		</div>
	</div>
</body>
</html>