<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
<div class="panel panel-primary">
	<!-- 面板头信息 -->
	<div class="panel-heading">
		<!-- 面板标题 -->
		<h3 class="panel-title">图书清单</h3>
	</div>
</div>
<div class="container">
	<div class="col-md-12">
		<div class="panel-body">
			<!-- 响应式表格 -->
			<div class="table table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="text-center">书名</th>
							<th class="text-center">价格</th>
							<th class="text-center">数量</th>
						</tr>
					</thead>
		
					<tbody class="text-center">
						<c:forEach items="${requestScope.listbook }" var="book">
							<tr>
								<td>${book.name}</td>
								<td>${book.price}</td>
								<td>${book.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>