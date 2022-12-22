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
		<h3 class="panel-title"><a href="/reader/exit">退出登录</a></a></h3>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-4">
		
			<H3>欢迎读者 ${sessionScope.reader.name}</H3><br>
		
		</div>
	</div>
	<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="text-center">
			  	  		<h3 class="panel-title">读者主页</h3>
			  	  	</div>
			  </div>
			  <div class="panel-body"></div>
				
					<div class="text-center">
			        	<span class="text-center">余额：<em style="color: #f57e42;font-style: normal;font-weight: bolder;">${sessionScope.reader.money}</em> 
						&nbsp;<a href="/reader/recharge"><button class="btn btn-warning xc" style="padding: 0.2rem 0.4rem;">充值</button></a>
						</span>
			        </div>
			        <br><br>
			        <div class="text-center">
			        	<span class="text-center"><a href="/reader/changepassword"><button class="btn btn-danger xc" style="padding: 0.2rem 0.4rem;">修改密码</button></a></span>
			        </div>
			        <br><br>
			        <div class="text-center">
			        	<span class="text-center"><a href="/reader/index"><button class="btn btn-primary xc" style="padding: 0.2rem 0.4rem;">选购图书</button></a></span>
			        </div>
			        <br><br>
			        <div class="text-center">
			        	<span class="text-center"><a href="/reader/bill"><button class="btn btn-info xc" style="padding: 0.2rem 0.4rem;">历史订单</button></a></span>
			        </div>
			        <br>
			</div>
		</div>
		
</div>
</body>
</html>
