<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>登录界面</title>
  
      <link rel="stylesheet" href="css/style.css">
	
    
</head>

<body>
<div id="time">
    北京时间： 2018年6月8日 星期五
</div>
<br>
<br>
<br>
<div class="top" style="width:100%;height:7%;">
	
	<img src="images/图层 1.png" width="100px" height="100px" style="margin-left: 5px; height: 108px"><span style="margin-left: 5px; height:80px;display:inline-block; line-height:20px; vertical-align: bottom; font-size: 45px;">学生成绩管理系统<br/><span style="opacity: 0.4;font-size:26px;">Jxnu Student System</span> </span>
</div>

  <div class="wrap">
  
  <br>
  <br>
  <ul class="tabs group">
    <li><a class="active" href="#/one">教师
    登录</a></li>
    <li><a href="#/two">学生登录</a></li>
  </ul>
  
  <div id="content">
   
    <div class="box" id="one">
    	<form action="teacher_login" method=post>
        <div class="group">
            <input class="inputMaterial" type="text" name="user" required >
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>工号</label>
        </div>
        <div class="group">
            <input class="inputMaterial" type="password" name="password1" required >
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>密码</label>
        </div>
        <button id="buttonlogintoregister" type="submit">登录</button>
        <button id="buttonlogintoregister" type="reset">重置</button>
 	    </form>
	</div>
    
    
    <div class="box" id="two">
    	<form action="student_login" method="post">
        <div class="group">
            <input class="inputMaterial" type="text" name="user_stu" required >
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>学号</label>
        </div>
        <div class="group">
            <input class="inputMaterial" type="password" name="password" required >
            <span class="highlight"   ></span>
            <span class="bar"></span>
            <label>密码</label>
        </div>
        <button id="buttonlogintoregister" type="submit">登录</button>
        <button id="buttonlogintoregister" type="reset">重置</button>
 	    </form>
    
	</div>
 
  </div>
  
</div>


    <script src="js/jquery-3.3.1.min.js"></script>

    <script  src="js/index.js"></script>
    
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
