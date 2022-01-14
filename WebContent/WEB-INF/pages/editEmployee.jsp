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
<fieldset class="layui-elem-field layui-field-title">
  <legend>编辑员工信息</legend>

</fieldset>
		<form class="layui-form" action="update" method="post">
		  <div class="layui-form-item">
		    <label class="layui-form-label">eid</label>
		    <div class="layui-input-block">
		      <input type="text" name="eid" value="${em.eid}" readonly class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">员工姓名</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" required  lay-verify="required" value="${em.name}" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">联系电话</label>
		    <div class="layui-input-block">
		      <input type="text" name="phone" required  lay-verify="required" value="${em.phone}" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  		  <div class="layui-form-item">
		    <label class="layui-form-label">电子邮箱</label>
		    <div class="layui-input-block">
		      <input type="email" name="email" required  lay-verify="required" value="${em.email}" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
    <label class="layui-form-label">员工类型</label>
    <div class="layui-input-block">
      <select name="type" lay-verify="required" value="${em.type}">
        <option value=""></option>
        <option value="0" <c:if test="${em.type==0}">
			  	selected
			  </c:if>>项目经理</option>
        <option value="1" <c:if test="${em.type==1}">
			  	selected
			  </c:if>>普通员工</option>
      </select>
    </div>
  </div>
  <input type="hidden" name="pid" value="${em.pid}">
  <input type="hidden" name="bonus" value="${em.bonus}">
  
		  	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" type="submit" lay-submit >立即提交</button>
	    </div>
	  </div>
		</form>	
			<script>
	//Demo
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
	</script>
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