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
			class="img-responsive img-thumbnail"/>
	</div>
	<div class="container-fluid">
		<div class="col-md-12">
			<div class="row-fluid">
				<div class="col-md-2"></div>
				<div class="col-md-8">

					<div class="row-fluid">
						<div class="col-md-3">
							<ul class="nav nav-stacked nav-pills">
								<li><a href="#">数据统计</a></li>
								<li class="active"><a href="categoryManagement">分类管理</a></li>
								<li><a href="articleManagement">博文管理</a></li>
							</ul>
						</div>
						<div class="col-md-9">
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

									<c:forEach items="${listAllCategory}" var="c" varStatus="st">
										<tr>
											<td>${c.id }</td>
											<td>${c.name }</td>
											<td>时间待完成</td>
											<td>${c.number }</td>
											<td>
												<div class="btn-group">
													<button type="button"
														class="btn btn-primary btn-sm btn-success"
														data-toggle="modal" data-target="#myModal${c.id }">编辑</button>
													<form action="deleteCategory">
														<button type="submit" name="name" value="${c.name }"
															class="btn btn-primary btn-sm btn-danger">删除</button>
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
															<form action="updateCategory" role="form" method="post">
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
																			<input type="text" class="form-control"
																				id="inputtext" name="name" placeholder="不要输入重复分类名称">
																			<input type="hidden" name="id" value=${c.id }>
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
								<div class="col-md-6">
									<form action="addCategory" method="post">
										<fieldset>
											<legend>新增分类</legend>
											<label>新增分类名</label><input type="text" name="name" /> <span
												class="help-block">注意：不要增加重复分类</span>
											<button type="submit" class="btn">确定</button>
										</fieldset>
									</form>
								</div>

								<div class="col-md-6"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>