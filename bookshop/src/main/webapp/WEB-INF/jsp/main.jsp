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
		<img src="/images/logo.png" alt="LOGO" width="30" height="30">
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-4">
		
			<H3>JLU网上书店系统欢迎您~</H3><br>
		
		</div>
	</div>
	<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="text-center">
			  	  		<h3 class="panel-title">入口选择</h3>
			  	  	</div>
			  </div>
			  <div class="panel-body"></div>
				
					
			        <div class="text-center">
			        	<span class="text-center"><a href="/admin/login"><button class="btn btn-danger xc" style="padding: 0.2rem 0.4rem;">管理员登录</button></a></span>
			        </div>
			        <br><br>
			        <div class="text-center">
			        	<span class="text-center"><a href="/reader/login"><button class="btn btn-primary xc" style="padding: 0.2rem 0.4rem;">读者登录</button></a></span>
			        </div>
			        <br><br>
			        <div class="text-center">
			        	<span class="text-center"><a href="/reader/register"><button class="btn btn-info xc" style="padding: 0.2rem 0.4rem;">读者注册</button></a></span>
			        </div>
			        <br>
			</div>
		</div>
		
		
</div>

<div class="text-muted small bg-dark py-4 mt-3" id="footer">
	<div class="container">
		<div class="row text-center">
			Developed by Shi J.P. <br>
			2022-12, &copy; Copyright Reserved.<br>
			吉林大学计算机科学与技术学院
		</div>
	</div>
</div>

</body>
</html>
