<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户注册</title>
		<!--手机屏幕自适应配置-->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- 新 Bootstrap4 核心 CSS 文件 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}bootstrap/js/bootstrap.min.js"></script>

		<!--加载页面自定义css-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
			
	</head>
	
	<body class="backcolor">
		<div class="row">
		<div class="col-md-4" ></div>
		<div class="container wbox col-md-4">
					<form action="register" method=post>
						<div class="logintitle">ET电力工程公司信息管理系统</div>
							<p align="center" color=red>${rerror}</p>
							<div>工号</div>
							<div><input type="text" name=eid placeholder="工号" class="form-control"></div>
							<div>用户名</div>
							<div><input type="text" name=uname placeholder="用户名" class="form-control"></div>
							<div>密码</div>
							<div><input type="password" name=upwd placeholder="密码" max=8 class="form-control"></div>	
						<div><button type="submit" class="btn btn-primary btn-block" style="margin-top: 20px;">注册</button></div>
					</form>
		</div>
		<div class="col-md-4" ></div>
		</div>
		<div class="fonter">Copyright &copy; 版权所有 ET电力工程有限公司</div>
	
	</body>
</html>
