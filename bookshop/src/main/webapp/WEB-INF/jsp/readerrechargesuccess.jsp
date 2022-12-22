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
		<h3 class="panel-title"><a href="/reader/homepage">返回</a></a></h3>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-4">
		
			<H3>您的余额： ${sessionScope.reader.money}</H3><br>
		
		</div>
	</div>
	<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="text-center">
			  	  		<h3 class="panel-title">充值</h3>
			  	  	</div>
			  </div>
			  <div class="panel-body"></div>
				
					
			        <div class="text-center">
			        	<form method="POST" action="/reader/rechargeon">
								金额：<input type="text" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" name="money" size="20" required>
								<input type="submit" value="充值" name="B1">
						</form>
						<br>
						<div class="text-primary">充值成功！</div>
			        </div>
			        
			        <br>
			</div>
		</div>
		
</div>
</body>
</html>
