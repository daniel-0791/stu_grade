<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成绩管理</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  
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
 
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/top.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
</head>
<body >
<div class="panel panel-default">
    <div class="panel-heading">成绩</div>
    <div class="panel-body">
        <table class="table table-bordered">
   	<center>
   	
 <div class="col-10 content2 " >
    	<table class="table table-hover">
		    <thead>
		      <tr>
		     
		 	
		      </tr>
		    </thead>
		    <tbody>
		    
		    
		    
		    
		  
		    
		      	<tr>
    		<td>平均分</td>
				  <td>${avg}</td>
	
				</tr>
		    <tr>
    		<td>最高分</td>
				  <td>${max}</td>
	
				</tr>
				<tr>
    		<td>最低分</td>
				  <td>${min}</td>
	
				</tr>
		
		    
		    </tbody>
		  </table>
    </div></center>
        </table>
    </div>
</div>

</body>
</html>