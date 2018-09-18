<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>选课</title>
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
    </style>
    <script language="javascript">

</script>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/top.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
</head>
<body >


<div class="panel panel-default">
    <div class="panel-heading">预选选课</div>
    <div class="panel-body">
        <table class="table table-bordered">
   	<center>
 
 <div class="col-10 content2 " >
    	<table class="table table-hover">
		    <thead>
		      <tr>
		        <th>课程号</th>
		        <th>课程名</th>
		        <th>学分</th>
		        <th>类别</th>
		      </tr>
		    </thead>
		    <tbody>


		    <c:forEach items="${courselist1}" var="course">
		<!-- //items 用于接收集合对象，var 定义对象接收从集合里遍历出的每一个元素 -->
			<tr>
				<td>${course.ccode }</td>
				<td>${course.cname }</td>
			
				<td>${course.score }</td>
				<td>${course.category}</td>
				<td>
					
				
					
					
				  <td><button type="button" class="btn btn-warning" 
	 onclick="javascript:updatecourse(${id},${course.id },'${course.ccode }','${course.cname }',${course.score});" >添加</button></td>
			</tr>
		</c:forEach>
           <button type="button" class="btn btn-warning"
                    onclick="javascript:stu_course_list();" >结束选课</button></td>
		    </tbody>
		  </table>
    </div></center>
        </table>
    </div>
</div>

	<script type="text/javascript">

        function stu_course_list(){
            if(window.confirm("是否结束课程(y/n)？")){

                window.location="new_stusys?";
            }
        }

		function updatecourse(stu_id,id,ccode,cname,score,list){
			if(window.confirm("是否要添加该数据(y/n)？")){
				  						
				window.location="course_add?stu_id="+stu_id+"&id="+id+"&ccode="+ccode+"&cname="+cname+"&score="+score;
			}			
		}	
		if("<%= request.getAttribute("name")  %>"=="已存在"){
	alert("已存在");}
	
		else if( "<%= request.getAttribute("name") %>" =="插入成功"){
	alert("插入成功");
	}
			else if("<%= request.getAttribute("name") %>" =="已超过本学期学分30分")
				{
				alert("已超过本学期学分30分");
				}

				
	
	
	
	
	</script>
</body>
</html>