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
		<div class="row-fluid">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row-fluid">
					<div class="col-md-2">
						<ul class="nav nav-stacked nav-pills">
							<li><a href="statisticManagement">数据统计</a></li>
							<li><a href="categoryManagement">分类管理</a></li>
							<li class="active"><a href="articleManagement">博文管理</a></li>
						</ul>
					</div>
					<div class="col-md-10">
						<table class="table">
							<thead>
								<tr>
									<th>文章ID</th>
									<th>文章标题</th>
									<th>创建时间</th>
									<th>阅读数量</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listAllArticle}" var="a" varStatus="st">
									<tr>
										<td>${a.id }</td>
										<td>${a.title }</td>
										<td>时间待完成</td>
										<td>阅读量待完成</td>
										<td>
											<div class="btn-group">
											
												<button type="button"
													class="btn btn-primary btn-sm btn-success"
													data-toggle="modal" data-target="#myModal${a.id }">编辑</button>
												<form action="deleteArticle">
													<button type="submit" name="article_id" value="${a.id }"
														class="btn btn-primary btn-sm btn-danger">删除</button>
												</form>
											</div>
											<div class="modal fade" id="myModal${a.id }" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myModalLabel">编辑文章</h4>
														</div>
														<form action="updateArticle" role="form" method="post">
															<div class="modal-body">
																<div class="form-group">
																	<label class=" control-label" for="inputtitle">文章标题</label>
																	<div>
																		<input type="text" class="form-control" name="title"
																			id="inputtitle" value="${a.title }"> <input
																			type="hidden" name="article_id" value="${a.id }">
																	</div>
																</div>
																<div class="form-group">
																	<label for="summaryarea">文章简介</label>
																	<textarea class="form-control" rows="3"
																		id="summaryarea" name="summary">
																		${a.summary }
																	</textarea>
																</div>
																<div class="form-group ">
																	<label for="sel1">文章分类</label> <select
																		class="form-control" id="sel1" name="name">
																		<option selected="selected" value="其他分类" />
																		<c:forEach items="${listAllCategory}" var="c"
																			varStatus="st">
																			<option value="${c.name }">${c.name }</option>
																		</c:forEach>
																	</select>
																</div>
																<div class="form-group">
																	<label for="contentarea">文章内容</label>
																	<textarea class="form-control" id="contentarea"
																		rows="3" name="content">
																	</textarea>
																</div>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">取消</button>
																<button type="submit" class="btn btn-primary">
																	确认修改</button>
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
						<ul class="pagination pagination-centered pagination-lg">
											<li><a href="?start=0">首 页</a></li>
											<li><a href="?start=${page.start-page.count }">上一页</a>
											<li><a href="?start=${page.start+page.count }">下一页</a>
											<li><a href="?start=${page.last }">末页</a>
										</ul>
						<form action="addArticle" role="form" method="post">
							<div class="form-group ">
								<label>文章标题</label><input type="text" name="title"
									class="form-control">
							</div>
							<div class="form-group ">
								<label>文章简介</label>
								<textarea class="form-control" rows="3" name="summary">
							</textarea>
							</div>
							<div class="form-group ">
								<label for="sel1">文章分类</label> <select class="form-control"
									id="sel1" name="name">
									<option selected="selected" value="其他分类" />
									<c:forEach items="${listAllCategory}" var="c" varStatus="st">
										<option value="${c.name }">${c.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>文章内容</label>
								<textarea class="form-control" rows="5" name="content">
							</textarea>
							</div>
							<button type="submit" class="btn btn-default">确认添加</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>

		</div>
	</div>
</body>
</html>
