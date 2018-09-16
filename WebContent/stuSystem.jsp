<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
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
            text-align:center;
             background:url(images/360.png);
           
            background-repeat:no-repeat;
             background-size:100% ;
        }
        #time{
            background:url(images/t02bg.png);
            width:100%;
            height:15px;
            background-repeat:no-repeat;
            background-size:cover;
            font-size:12px;
        }
        #all{
            width: 1006px;
        }
        #left{
            height: 500px;
        }
        #right{
            height: 500px;
        }
    </style>
</head>
<body>
<div id="time">
    北京时间： 2018年6月8日 星期五
</div>
<div id="all">
    <div id="log">
        <img src="images/8.jpg" class="img-responsive img-thumbnail">
    </div><link rel="stylesheet" href="mbcsmbinsmenu0.css" type="text/css" />


<!-- Navigation menus created with the free version of Easy CSS Menu downloaded from www.easycssmenu.com
     You are free to use this menu code for personal, non-commercial use only. Any other use is a serious violation of copyright laws.
     You are required to retain this comment block in your website code in an unchanged fashion.
     The above limitations do not apply on menus created with the paid version of the software. -->
<div id="mbinsmenu0ebul_wrapper" style="max-width: 996px;">
  <ul id="mbinsmenu0ebul_table" class="mbinsmenu0ebul_menulist css_menu">
  <li><div class="buttonbg gradient_button gradient34" style="width: 151px;height: 34px;"><a>&nbsp;&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;&nbsp;</a></div></li>
  <li><div class="buttonbg gradient_button gradient33" style="width: 152px;height: 33px;"><div class="arrow"><a class="button_2">推荐课程</a></div></div>
    <ul class="gradient_menu gradient108">
    <li class="first_item"><a title="">工科</a></li>
    <li><a title="">理科</a></li>
						<li class="last_item"><a title="">体课</a></li>
					</ul></li>
  <li><div class="buttonbg gradient_button gradient44" style="height: 44px;"><a class="button_3">任课老师</a></div></li>
  <li><div class="buttonbg gradient_button gradient45" style="width: 130px;height: 45px;"><a class="button_4">教学名师</a></div></li>
  <li><div class="buttonbg gradient_button gradient43" style="width: 119px;height: 43px;"><a class="button_5">文档下载</a></div></li>
  <li><div class="buttonbg gradient_button gradient46" style="width: 122px;"><a class="button_6">网上教学</a></div></li>
  <li><div class="buttonbg gradient_button gradient41" style="width: 131px;height: 41px;"><a class="button_7" href="quit">&nbsp;&nbsp;&nbsp;退出&nbsp;&nbsp;&nbsp;&nbsp;</a></div></li>
  </ul>
</div>
<!-- Menus will work without this javascript file. It is used only for extra
     effects, improved usability, compatibility with very old web browsers
     and support for touch screen devices. -->
<script type="text/javascript" src="mbjsmbinsmenu0.js"></script>
    <link rel="stylesheet" href="mbcsmbstxy.css" type="text/css" />



<script type="text/javascript" src="mbjsmbstxy.js"></script>
    
    <div id="left" class="col-md-2 thumbnail">
        <br>
        <br>
        <div>
          <a  target="chaxun"><%= "欢迎你! " %>${name}</a>
        </div>
        <div>
        <img  src="${photo}" width="70px" height="70px">
        </div>
        <ul class="nav nav-pills nav-stacked">
        
          
            <li><a  href="peiyangfangan.jsp" target="chaxun">培养方案</a></li>
             <li><a  href="searchCourse.jsp" target="chaxun">课程查询</a></li>
             <li><a  href="courselist" target="chaxun">预     &nbsp; &nbsp; &nbsp;选</a></li>
            <li><a href="stu_course_list" target="chaxun">正  &nbsp; &nbsp; &nbsp;选</a></li>
            
           <li><a href="query_grade" target="chaxun">成绩查询</a></li>
           
           
        </ul>
    </div>
    <div id="right" class="col-md-10 thumbnail">
        <iframe name="chaxun" width="100%" height="100%" frameborder="0"></iframe>
    </div>
    <div id="footer">
        地址：中国·南昌市紫阳大道99号 (瑶湖校区) 江西师范大学教务处<br>
        邮编：330022 电话：0791-88120270 传真：0791-88120270<br>
        技术支持&版权所有：江西师范大学教务处<br>
    </div>
</div>
<script type="text/javascript">
    showTime();
    function showTime(){
        var myDate = new Date(),
            year = myDate.getFullYear(),
            month = myDate.getMonth() + 1,
            date = myDate.getDate(),
            d = myDate.getDay(),
            h = myDate.getHours(),
            m = myDate.getMinutes(),
            s = myDate.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        var weekday = new Array(7);
        weekday[0] = "星期日";
        weekday[1] = "星期一";
        weekday[2] = "星期二";
        weekday[3] = "星期三";
        weekday[4] = "星期四";
        weekday[5] = "星期五";
        weekday[6] = "星期六";
        document.getElementById("time").innerHTML ='北京时间' + year + '年' + month + '月' + date + '日' + weekday[d] + h + ':' + m + ':' + s ;
        setTimeout(showTime,500);
    }

    function checkTime(i){
        if(i < 10){
            i = '0' + i;
        }
        return i;
    }

</script>
</body>
</html>
