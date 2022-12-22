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
		<h3 class="panel-title"><a href="/reader/homepage">返回</a></h3>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-4">
		<div class="text-center">
			<H3>您的余额： ${sessionScope.reader.money}</H3><br>
		</div>
		</div>
	</div>
	<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="text-center">
			  	  		<h3 class="panel-title">您的购物车</h3>
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
							<c:forEach items="${sessionScope.shopcart.cart }" var="book">
								<tr>
								 	<td><span class="text-center">${book.id}</span></td>
									<td><span class="text-center">${book.name}</span></td>
									<td><span class="text-center">${book.price}</span></td>
									<td>
									<span class="text-center">
								
										<a href="/reader/sub?id=${book.id}"><button type="button" class="panel-title" style="color:#000000;border-radius:50%;border: none">-</button></a>
			        					&nbsp;
										${book.quantity}
										&nbsp;
										<a href="/reader/add?id=${book.id}"><button type="button" class="panel-title" style="color:#000000;border-radius:50%;border: none">+</button></a>
								
									</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center">购书总价</th>
								<th class="text-center">${sessionScope.shopcart.total }</th>
							</tr>
						</thead>
					</table>
				</div>
				
			</div>
			
			
					<div class="text-center">
			        	<span class="text-center"><a href="/reader/index"><button type="button" class="panel-title" style="color: #000000;">继续选购</button></a></span>
			        	&nbsp;&nbsp;
			        	<span class="text-center"><a href="/reader/pay"><button type="button" class="panel-title" style="color: #000000;">支付结算</button></a></span>
			        	<br><br>
						<div class="text-danger">您的购物车为空！</div>
			        </div>
			        <br>
			  
			</div>
		</div>
		
</div>
</body>
</html>