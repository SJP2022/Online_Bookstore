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
			<h3>支付成功！本次订单号为：${id }</h3>
		</div>
		</div>
	</div>
	<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="text-center">
			  	  		<h3 class="panel-title">订单信息</h3>
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
								<th class="text-center">书名</th>
								<th class="text-center">单价</th>
								<th class="text-center">数量</th>
								<th class="text-center">购书时间</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<c:forEach items="${sessionScope.listbill }" var="bill">
								<tr>
									<td>${bill.name}</td>
									<td>${bill.price}</td>
									<td>${bill.quantity}</td>
									<td>${bill.time}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center">购书总价</th>
								<th class="text-center">${total }</th>
							</tr>
						</thead>
					</table>
				</div>
				
			</div>
			
			
			        <div class="text-center">
			        	<span class="text-center"><a href="/reader/index"><button type="button" class="panel-title" style="color: #000000;">继续选购</button></a></span>
			        	&nbsp;&nbsp;
			        	<span class="text-center"><a href="/reader/homepage"><button type="button" class="panel-title" style="color: #000000;">结束购书</button></a></span>
			        	
			        </div>
			        <br>
			  
			</div>
		</div>
		
</div>
</body>
</html>
