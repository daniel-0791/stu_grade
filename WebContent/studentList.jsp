<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生列表</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="jquery-3.3.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
        *{
            word-wrap:break-word;
        }
        html, body, h1, h2, h3, h4, h5, h6, div, ul, ol, li, dl, dt, dd, iframe, form, textarea, input, select, button, p, strong, b, i, a, span, table, tr, th, td,img,object,embed{
            margin:0 auto;
            padding:0;
        }
        img,table,tr,td{
            border:0;
        }
        body{
            text-align: center;
          
        }
        td,p{
        
            text-align: left;
            
        }
        #myModal{
            /* position: absolute; */
            top: 300;
            left: 500;
            transform: translate(-50%, -50%);
            text-align: left;
        }
        
    </style>
    <script type="text/javascript">
function a() {
	if(window.name == null || window.name == ""){
        window.name = "enter";
       window.location.href = "studentList";
    }else{
       
    }

}
</script>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/top.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
</head>
<body onload="a()">
<div class="panel panel-default">
    <div class="panel-heading">成绩</div>
    <div class="panel-body">
        <table class="table table-bordered">
   	<center>
   
 <div>
    	<table class="table table-hover">
		    <thead>
		      <tr>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>学号</th>
		        <th>班级</th>
		 		<th>照片</th>
		 		<th>信息</th>
		 		
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach items="${studentlist}" var="stu" varStatus="status">
		      	<tr>
				  <td>${stu.name }</td><!-- //el表达式 -->
				  <td>${stu.gender }</td>
				  <td>${stu.scode }</td>
				  <td>${stu.class_id }</td>
				    
				  <td rowspan="2" colspan="1"><img src="${stu.photo}" width="30px" height="30px"></td>
				
				  <td><!-- 按钮触发模态框 -->
                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal${status.count}">
                        	查看详情
                    </button>
                  <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal${status.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        学生信息详情
                    </h4>
                </div>
                <div class="modal-body">
                    <table class="table table-striped" border="1px">
                    
                        <tr>
                            <th>姓名</th>
                            <td>${stu.name }</td>
                            <td rowspan="3" width="100px"><img src="${stu.photo}" width="90px" height="120px"> </td>
                        </tr>
                        <tr>
                            <th>成绩</th>
                            <td>${stu.gender }</td>
                        </tr>
                        <tr>
                            <th>学号</th>
                            <td>${stu.scode }</td>
                        </tr>
                        <tr>
                            <th>班级号</th>
                            <td>${stu.class_id }</td>
                        </tr>
                    
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
                  </td>
				</tr>
				<tr></tr>
		      </c:forEach>
		    </tbody>
		  </table>
    </div></center>
        </table>
    </div>
</div>
	
	
</body>
</html>