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
		<h3 class="panel-title"><a href="/admin/book">返回</a></h3>
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
			  	  		<h3 class="panel-title">修改${requestScope.book.id}号图书的信息</h3>
			  	  	</div>
			  </div>
			  <div class="panel-body"></div>
			
			
			        <div class="text-center">
			        	<form method="POST" action="/admin/change">
				        	书名<input type="text" name="name" size="20" value="${requestScope.book.name}" required><br><br>
							价格<input type="text" onkeyup="value=value.replace(/^\D*(\d*(?:\.\d{0,2})?).*$/g, '$1')" name="price" size="20" value="${requestScope.book.price}" required><br><br>
							数量<input type="number" name="quantity" size="20" value="${requestScope.book.quantity}" required><br><br>
							
							<input type="submit" value="确定" name="B1">&nbsp;&nbsp;<input type="reset" value="重置" name="B2">
						</form>
						<br>
						<div class="text-primary">图书信息修改成功！</div>
			        </div>
			        <br>
			  
			</div>
		</div>
		
</div>
</body>
</html>