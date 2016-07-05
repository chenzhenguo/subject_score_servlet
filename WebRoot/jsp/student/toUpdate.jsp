<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>


</head>

<body>
	<!--<![endif]-->

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<ul class="nav pull-right">

					<li id="fat-menu" class="dropdown"><a href="#" id="drop3"
						role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i>${sessionScope.currentUser.name } <i
							class="icon-caret-down"></i>
					</a>

						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="user?action=logout">Logout</a></li>
						</ul></li>

				</ul>
				<a class="brand" href="jsp/login.jsp"><span class="first">积分</span>
					<span class="second">管理系统</span></a>
			</div>
		</div>
	</div>


	<div class="container-fluid">

		<div class="row-fluid">
			<div class="span3">
				<div class="sidebar-nav">
					<div class="nav-header" data-toggle="collapse"
						data-target="#dashboard-menu">系统管理</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li><a href="position">职位管理</a></li>
						<li><a href="dept">部门管理</a></li>
						<li><a href="class">班级管理</a></li>
						<li><a href="subject">课程管理</a></li>

					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">人员管理</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li class="active"><a href="stu">学生管理</a></li>
						<li><a href="teacher">教师管理</a></li>
						<li><a href="status">学生状态管理</a></li>
					</ul>

					<div class="nav-header" data-toggle="collapse"
						data-target="#settings-menu">积分管理</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li><a href="reason">积分原因管理</a></li>
						<li><a href="points">积分管理</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">


				<h1 class="page-title">修改学生信息</h1>

				<div class="well">
					<ul class="nav nav-tabs">


					</ul>
					<div id="myTabContent" class="tab-content"   >
						<div class="tab-pane active in" id="home">
							<form id="tab" method="post" action="stu?action=update">
								<input type="hidden" value="${student.id }" name="id"> <label>姓名</label>

								<input type="text" value="${student.name}" name="name"
									class="input-xlarge">
									
									
									 <label>年龄</label> <input
									type="text" value="${student.age }" name="age"
									class="input-xlarge"> 
									
									 <label>身份证号</label>

								<input type="text" value="${student.idCard}" name="idCard"
									class="input-xlarge">
									
									
									
									<label>性别</label> <input
									type="radio" value="1" name="sex"
									<c:if test="${student.sex=='1' }">checked</c:if>
									class="input-xlarge">男 <input type="radio" value="0"
									name="sex" <c:if test="${student.sex=='0' }">checked</c:if>
									class="input-xlarge">女 <label>状态</label> <input
									type="radio" value="1" name="statusId"
									<c:if test="${student.statusId=='1' }">checked</c:if>
									class="input-xlarge">在读 <input type="radio" value="2"
									name="statusId"
									<c:if test="${student.statusId=='2' }">checked</c:if>
									class="input-xlarge">留级 <input type="radio" value="3"
									name="statusId"
									<c:if test="${student.statusId=='3' }">checked</c:if>
									class="input-xlarge">退学 <input type="radio" value="4"
									name="statusId"
									<c:if test="${student.statusId=='4' }">checked</c:if>
									class="input-xlarge">就业 <input type="radio" value="5"
									name="statusId"
									<c:if test="${student.statusId=='5' }">checked</c:if>
									class="input-xlarge">休学 </select> <label>电话</label> <input
									type="text" name="phone" value="${student.phone}"> <label>专业</label>
								<input type="text" name="mayor" value="${student.mayor }">

								<label>学历</label> <input type="text" name="education"
									value="${student.education }"> <label>学校</label> <input
									type="text" name="school" value="${student.school }"> <label>地址</label>
								<input type="text" name="address" value="${student.address }">
								<label>入学日期</label> <input type="text" name="hireDate"
									value="${student.hireDate }"><br> <input
									type="submit"   class="btn  btn-xlarge" value="提交">

							</form>
						</div>
						<div class="tab-pane fade" id="profile">
							<form id="tab2">
								<label>New Password</label> <input type="password"
									class="input-xlarge">
								<div>
									<button class="btn btn-primary">Update</button>
								</div>
							</form>
						</div>
					</div>

				</div>

				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">Delete Confirmation</h3>
					</div>
					<div class="modal-body">

						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>Are you sure you want
							to delete the user?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						<button class="btn btn-danger" data-dismiss="modal">Delete</button>
					</div>
				</div>

			</div>
		</div>



		<footer>
			<hr>
			<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
			<p class="pull-right">
				A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free
					Bootstrap Theme</a> by <a href="http://www.portnine.com"
					target="_blank">Portnine</a>
			</p>


			<p>
				&copy; 2012 <a href="http://www.portnine.com">Portnine</a>
			</p>
		</footer>




		<!-- Le javascript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>


