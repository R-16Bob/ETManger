<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>ET电力工程信息管理系统</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">ET电力工程信息管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="../employee/index">员工管理</a></li>
      <li class="layui-nav-item"><a href="../user/index">系统用户管理</a></li>
      <li class="layui-nav-item"><a href="../customer/index">客户管理</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          欢迎，${uname}
        </a>

      </li>
      <li class="layui-nav-item"><a href="../user/logout">注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="../projectView/index">所有项目</a>
		  <dl class="layui-nav-child">
		    <dd><a href="../project/info?pid=${project.pid}">当前项目：${project.pname}</a></dd>
		  </dl>
        </li>
        <li class="layui-nav-item"><a href="../project/staff?pid=${project.pid}">项目成员管理</a></li>
        <li class="layui-nav-item"><a href="../event/index?pid=${project.pid}">项目收支管理</a></li>
		<li class="layui-nav-item"><a href="../project/tofinish?pid=${project.pid}">项目进度管理</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body " style="background-color: #ffffff;">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
            <a href="../project/tofinish?pid=${project.pid}" class="layui-btn "><i class="layui-icon">&#xe642;</i> 结束项目</a>
			<a href="../project/count?pid=${project.pid}" class="layui-btn "><i class="layui-icon">&#xe642;</i> 计算利润</a>
		<fieldset class="layui-elem-field layui-field-title">
  <legend>项目信息</legend>
</fieldset>
		<table class="layui-table">
		  <thead>
		    <tr>
		      <th>pid</th>
		      <th>项目名称</th>
		      <th>开始时间</th>
		      <th>结束时间</th>			  
			  <th>项目进度</th>
			  <th>盈亏</th>
			  <th>利润率</th>
		    </tr> 
		  </thead>
		  <tbody>		 
		    <tr>
		      <td>${project.pid}</td>
		      <td>${project.pname}</td>
		      <td>${project.btime}</td>
		      <td>${project.etime}</td>
			  <td>
			  <c:if test="${project.finish==0}">
			  	未完成
			  </c:if>
			  <c:if test="${project.finish==1}">
			  	已完成
			  </c:if>
			  </td>
			  <td>${project.profit}</td>
			  <td>${project.prate}</td>
		    </tr>
		  </tbody>
		</table>
		<br>
		<fieldset class="layui-elem-field layui-field-title">
  <legend>客户信息</legend>
</fieldset>
	<table class="layui-table">

		  <thead>
		    <tr>
		      <th>cid</th>
		      <th>客户名称</th>
		      <th>电话</th>
			  <th>电子邮箱</th>
		    </tr> 
		  </thead>
		  <tbody>
		    <tr>
		      <td>${customer.cid}</td>
		      <td>${customer.cname}</td>
		      <td>${customer.phone}</td>
			  <td>${customer.email}</td>
		    </tr>
		  </tbody>
		</table>
	</div>
	
  </div>
  
  <div class="layui-footer" style="text-align: center;">
    <!-- 底部固定区域 -->
    © 版权所有 ET电力工程有限公司
  </div>
</div>
<script src="../src/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>