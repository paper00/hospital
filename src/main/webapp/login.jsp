<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="#" />
    <link type="text/css" rel="styleSheet"  href="index-css/main.css" />
    <link type="text/css" rel="styleSheet"  href="index-css/style.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        #title {
            letter-spacing:17px;
            padding-left:30px;
        }
    </style>
</head>

<body>

<div id="bg">
  <div id="login_wrap">
    <div id="login">
      <div id="status">
        <i style="top: 0">Log</i>
        <i style="top: 35px">Sign</i>
        <i style="right: 5px">in</i>
      </div>
      <span>
            <form action="login.do" method="post">
                <p class="form"><input type="text" id="username" name="username" placeholder="username"></p>
                <p class="form"><input type="password" id="password" name="password" placeholder="password"></p>
                <p class="form confirm"><input type="password" id="confirm-passwd" placeholder="confirm password"></p>
                <input type="submit" value="Log in" class="btn" onclick="login()" style="margin-right: 20px;">
                <input type="button" value="Sign in" class="btn" onclick='signin()' id="btn">
            </form>
            <c:if test="${ not empty error_type }">
	           	<div style="font-size: 17px; color: white; margin-top:61px;"> ${ error_type } </div>
	        </c:if>
	        <c:if test="${ empty error_type }">
	        	<a href="#">Forget your password?</a>
	        </c:if>
      </span>
      
    </div>

    <div id="login_img"><!-- 图片绘制框 -->
      <span class="circle">
                    <span></span>
                    <span></span>
                </span>
      <span class="star">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </span>
      <span class="fly_star">
                    <span></span>
                    <span></span>
                </span>
      <p id="title"> HOSPITAL</p>
    </div>
  </div>
  
</div>
</body>
</html>
