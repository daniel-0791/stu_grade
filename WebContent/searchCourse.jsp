<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center"><strong>
		<span id="_ctl1_Label2" style="font-size:12pt;">课程查询</span>
	</strong>
</div>
<form action="searchCourse" method="">
<table width="98%" border="0" align="center" cellspacing="0">
	<tr>
		<td height="25"><div align="right">
				<table width="100%" border="1" cellspacing="0" bordercolorlight="#000000" bordercolordark="#ffffff">
					<tr>
						<td background="../images/bg_2.gif" bgcolor="#000000"><table width="100%" border="0" cellspacing="0">
								<tr>
									
									<td width="18%"><div align="center"><font color="#ffffff">请您输入关键字：</font></div>
									</td>
									<td width="35%"><div align="center"></div>
										<input name="key_word" type="text" maxlength="40"  title="在此输入关键字" style="font-weight:bold;width:100%;" />
									</td>
									<td width="14%"><div align="center">
											<select name="key_type" id="_ctl1_key_type" style="width:100%;">
>
	<option value="kcmc" ID="Listitem2">课程名称</option>

</select>
										</div>
									</td>
									
									</td>
									<td></td>
									<td width="25%"><input type="submit" name="_ctl1:ok" value="查 询" id="_ctl1_ok" />
										&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</form>
				    </table>
	  <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/top.css" />
<link type="text/css" rel="stylesheet" href="css/index.css" />			
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
		    <c:forEach items="${courselist2}" var="course">
		<!-- //items 用于接收集合对象，var 定义对象接收从集合里遍历出的每一个元素 -->
			<tr>
	
				<td>${course.ccode }</td>
				<td>${course.cname }</td>	
				<td>${course.score }</td>
				<td>${course.category }</td>
						
			</tr>
		</c:forEach>
		    </tbody>
		  </table>
    </div>
    
  
</body>
</html>