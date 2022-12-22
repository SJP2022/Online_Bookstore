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
			  	  		<h3 class="panel-title">修改密码</h3>
			  	  	</div>
			  </div>
			  <div class="panel-body"></div>
			
			
			        <div class="text-center">
				        <form method="POST" action="/admin/checkpassword">
							旧密码：<input type="password" name="password1" size="20" required><br><br>
							新密码：<input type="password" name="password2" size="20" required><br><br>
							
							<input type="submit" value="确定" name="B1">&nbsp;&nbsp;<input type="reset" value="重置" name="B2">
						</form>
			        	
			        </div>
			        <br>
			  
			</div>
		</div>
		
</div>
</body>
</html>