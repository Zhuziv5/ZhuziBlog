<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/zhuziblog/blogs/article">我的博客</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="/zhuziblog/blogs/article">主页</a></li>
				<li><a href="/zhuziblog/blogs/category">分类</a></li>
				<li><a href="/zhuziblog/admin/articleManagement">管理</a></li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<input type="text" class="form-control" placeholder="search">
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
		</div>
	</div>
</nav>
