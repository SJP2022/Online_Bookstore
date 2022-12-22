<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel panel-success">
	<!-- .panel-heading 面板头信息。 -->
	<div class="panel-heading">
		<!-- .panel-title 面板标题。 -->
		<h3 class="panel-title"><a href="/admin/homepage">返回</a></h3>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-4">
		<div class="text-center">
			
		</div>
		</div>
	</div>
	<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="text-center">
			  	  		<h3 class="panel-title">图书信息列表</h3>
			  	  	</div>
			  </div>
			  <div class="panel-body">
				<!-- table-responsive:响应式表格,在一个表展示所有的数据,当不够显示的时候可以左右滑动浏览-->
				<div class="table table-responsive">
					<!--
	                	.table-bordered 类为表格和其中的每个单元格增加边框。
	                	.table-hover 类可以让 <tbody> 中的每一行对鼠标悬停状态作出响应。
	                -->
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center">书号</th>
								<th class="text-center">书名</th>
								<th class="text-center">价格</th>
								<th class="text-center">数量</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<c:forEach items="${requestScope.listbook }" var="book">
								<tr>
								 	<td>${book.id}</td>
									<td>${book.name}</td>
									<td>${book.price}</td>
									<td>${book.quantity}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			</div>
			
			
			        <div class="text-center">
			        	<form method="POST" action="/admin/changebook" class="panel-title">
							书号<input type="number" min="1" max ="${requestScope.listbook.size()}" name="id" size="20" required>
							<input type="submit" value="修改图书信息" name="B1">
						</form>
			        </div>
			        <br>
			        <div class="text-center">
			        	<form method="POST" action="/admin/add" class="panel-title">
							<input type="submit" value="添加新图书" name="B1">
						</form>
			        </div>
			        <br>
			  
			</div>
		</div>
		
</div>
</body>
</html>