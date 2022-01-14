<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
</body>
<div class="container">
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th>uid</th>
				<th>uname</th>
				<th>upwd</th>
				<th>Opt</th>
			</tr>
		</thead>
		<tbody>
		  
			<c:forEach var="user" items="${ulist}" varStatus="status">
				<tr>
					<td>${user.uid}</td>
					<td>${user.uname}</td>
					<td>${user.upwd}</td>
					<td>${user.eid}</td>
					<td>
						<a  class="btn btn-primary" href="edit?uid=${user.uid}">修改</a>
					    <a  class="btn btn-warning" href="delete?uid=${user.uid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>

