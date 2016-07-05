<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>

    <!-- Demo page code -->
    
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
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
                    
                    <li id="fat-menu" class="dropdown">
                        <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i>${sessionScope.currentUser.name }
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="user?action=logout">Logout</a></li>
                        </ul>
                    </li>
                    
                </ul>
                 <a class="brand" href="jsp/login.jsp"><span class="first">积分</span> <span class="second">管理系统</span></a>
            </div>
        </div>
    </div>
    

    <div class="container-fluid">
        
        <div class="row-fluid">
            <div class="span3">
                <div class="sidebar-nav">
                  <div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu">系统管理</div>
                    <ul id="dashboard-menu" class="nav nav-list collapse in">
                        <li  ><a href="position">职位管理</a></li>
                        <li ><a href="dept">部门管理</a></li>
                        <li ><a href="classs">班级管理</a></li>
                        <li ><a href="subject">课程管理</a></li>
                        
                    </ul>
                <div class="nav-header" data-toggle="collapse" data-target="#accounts-menu">人员管理</div>
                <ul id="dashboard-menu" class="nav nav-list collapse in">
                  <li ><a href="stu">学生管理</a></li>
                  <li><a href="teacher">教师管理</a></li>
                  <li  class="active"><a href="status">学生状态管理</a></li>
                </ul>

                <div class="nav-header" data-toggle="collapse" data-target="#settings-menu">积分管理</div>
                <ul id="dashboard-menu" class="nav nav-list collapse in">
                  <li ><a href="reason">积分原因管理</a></li>
                  <li ><a href="points">积分管理</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
   

  <h1 class="page-title">学生状态管理</h1>
			<div class="btn-toolbar">
			    <button class="btn btn-primary"><i class="icon-plus"></i>添加</button>
			  <div class="btn-group">
			  </div>
			</div>
			
			<div class="well search-well">
                <form id="searchForm" class="form-inline" action="status" method="post">
                    <input class="input-xlarge pull-left" placeholder="原因名称" name="name" type="text" value="${status.name }">
                    <input class="pull-left btn" type="submit" value="查询"/>
                </form>
            </div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>id</th>
          <th>状态</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${list }" var="bean" varStatus="status">
        <tr>
          <td>${bean.id}</td>
          <td>${bean.name }</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" onclick="deleteStatus('${bean.id}');" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
      	</c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
	<script type="text/javascript">
	function deleteStatus(id){
		$("#pid").val(id);
	}
	function pageFunction(url){
		location.href=url+'&'+$('#searchForm').serialize();
	}
	</script>
    <ul>
    	<c:if test="${page.currentPage>1 }">
        <li><a href="javascript:pageFunction('status?action=list&currentPage=${page.currentPage-1 }')">Prev</a></li>
        </c:if>
        <c:choose>
        	<%-- 只要总页数小于10直接显示所有页数 --%>
        	<c:when test="${page.totalPage<10 }">
        		  <c:forEach begin="1" end="${page.totalPage }" var="pc" step="1">
	        	 	<li><a href="javascript:pageFunction('status?action=list&currentPage=${pc }')">${pc }</a></li>
	        	  </c:forEach>
        	</c:when>
        	<%-- 总页数大于10 --%>
        	<c:otherwise>
        		<%--当前页在头部  小于5--%>
        		<c:if test="${page.currentPage<5}">
        			<c:forEach begin="1" end="9" var="pc" step="1">
			        	 <li><a href="javascript:pageFunction('status?action=list&currentPage=${pc }')">${pc }</a></li>
			        </c:forEach>
        		</c:if>
        		<%-- 当前页在中间 --%>
        		<c:if test="${page.currentPage+4<=page.totalPage and page.currentPage-4>0}">
		        	 <c:forEach begin="${page.currentPage-4}" end="${page.currentPage+4 }" var="pc" step="1">
			        	 <li><a href="javascript:pageFunction('status?action=list&currentPage=${pc }')">${pc }</a></li>
			        </c:forEach>
		        </c:if>
		        <%-- 当前页在尾部 currentPage+4 大于 totalPage --%>
		        <c:if test="${page.currentPage+4>page.totalPage}">
		        	<c:forEach begin="${page.totalPage-8 }" end="${page.totalPage }" var="pc" step="1">
			        	 <li><a href="javascript:pageFunction('status?action=list&currentPage=${pc }')">${pc }</a></li>
			        </c:forEach>
		        </c:if>
        	</c:otherwise>
        </c:choose>
        <li><a href="javascript:pageFunction('status?action=list&currentPage=${page.currentPage+1 }')">Next</a></li>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除确认框</h3>
    </div>
    
	    <div class="modal-body">
	    	是否确定删除?
	    <form id="uploadForm" action="status" method="post">
			<input type="hidden" name="id" id="pid"/>
			<input type="hidden" name="action" value="delete"/>
	   	</form>
	    </div>
	    <div class="modal-footer">
	   		  <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	    	<input form="uploadForm" class="btn" type="submit" value="确定"/>
	    </div>
    
</div>

        </div>
    </div>
    

    
    <footer>
        <hr>
        <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
        <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
        <p>&copy; 2012 <a href="http://www.portnine.com">Portnine</a></p>
    </footer>
    
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath %>lib/bootstrap/js/bootstrap.js"></script>

  </body>
</html>


