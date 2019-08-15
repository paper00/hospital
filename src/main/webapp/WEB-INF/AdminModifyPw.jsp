<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Password</title>
    
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    
    <!-- Bootstrap core CSS     -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Animation library for notifications   -->
    <link href="../assets/css/animate.min.css" rel="stylesheet">
    
    <!--  Paper Dashboard core CSS    -->
    <link href="../assets/css/paper-dashboard.css" rel="stylesheet">
    
    
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../assets/css/demo.css" rel="stylesheet">
    
    
    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli:400,300" rel="stylesheet" type="text/css">
    <link href="../assets/css/themify-icons.css" rel="stylesheet">
    <script type="text/javascript">
	    function myFunction(){ 
			document.getElementById("doctor_sex").value="${ selected.sex }";
		} 
		myFunction();
    </script>
</head>

<body>
<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">
        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    Hospital
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="Admin.do">
                        <i class="ti-panel"></i>
                        <p>Main</p>
                    </a>
                </li>
                <li class="active">
                    <a href="modifyload.do">
                        <i class="ti-user"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                    <a href="AdminSectionList.do">
                        <i class="ti-view-list-alt"></i>
                        <p>Section</p>
                    </a>
                </li>
                <li>
                    <a href="AdminDoctorList.do">
                        <i class="ti-text"></i>
                        <p>Doctor</p>
                    </a>
                </li>
                <li>
                    <a href="AdminSearchPatient.do">
                        <i class="ti-pencil-alt2"></i>
                        <p>Search Patient</p>
                    </a>
                </li>
                <li>
                    <a href="AdminSearchIncome.do">
                        <i class="ti-map"></i>
                        <p>View Income</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="upgrade.html">
                        <i class="ti-export"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">${ user.usertype } : ${ user.username }</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
						<li>
                            <a href="modifypwload.do">
								<i class="ti-control-record"></i>
								<p style="color:grey;">修改密码</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image">
                                <img src="../assets/img/background.jpg" alt="...">
                            </div>
                            <div class="content">
                                <div class="author">
                                  <img class="avatar border-white" src="../assets/img/faces/face-2.jpg" alt="...">
                                  <h4 class="title">${ user.username }<br>
                                     <a href="#"><small>@${ user.usertype }</small></a>
                                  </h4>
                                </div>
                                <p class="description text-center">
                                    "I like the way you work it <br>
                                    No diggity <br>
                                    I wanna bag it up"
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-3 col-md-offset-1">
                                        <h5>12<br><small>Files</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5>2GB<br><small>Used</small></h5>
                                    </div>
                                    <div class="col-md-3">
                                        <h5>24,6$<br><small>Spent</small></h5>
                                    </div>
                                </div>
                                <!-- <div class="stats">
                                    <i class="ti-reload"></i> Updated now
                                </div> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">修改用户密码</h4>
                            </div>
                            <div class="content">
                                <form action="modifypw.do" method="post">
                                	<input type="hidden" name="id" value="${ user.id }">
                                    <div class="row">
	                                    
                                        <div class="col-md-5">
                                            <div class="form-group">
                                            	<label style="font-size:14px;">请输入原密码: </label>
                                                <input type="text" class="form-control border-input" name="ori_pw" value="">
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-5">
                                        	<c:if test="${ not empty wrong_1 }">
	                                        	<div style="margin-top:31px; margin-left:10px; color:red">
	                                        		<lable> ${ wrong_1 } </lable>
	                                        	</div>
                                        	</c:if>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                            	<label style="font-size:14px;">请输入新的密码: </label>
                                                <input type="text" class="form-control border-input" name="new_pw" value="">
                                            </div>
                                        </div>
                                         <div class="col-md-5">
                                        	<c:if test="${ not empty wrong_0 }">
	                                        	<div style="margin-top:31px; margin-left:10px; color:red">
	                                        		<lable> ${ wrong_0 } </lable>
	                                        	</div>
                                        	</c:if>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                            	<label style="font-size:14px;">请确认密码: </label>
                                                <input type="text" class="form-control border-input" name="new_pw_again" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${ not empty success }">
	                                    <div>
	                                    	<label style="margin-left:30px; color:black"> ${ success }! </label>
	                                    </div>
                                    </c:if>
                             		<input type="hidden" name="username" value="${ user.username }"/>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">修&nbsp;改</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
                
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                        </li>
                    </ul>
                </nav>
                <div class="copyright pull-right">
                </div>
            </div>
        </footer>

    </div>
</div>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <!---<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--->

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
    <script src="assets/js/paper-dashboard.js"></script>

    <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){

            demo.initChartist();

            $.notify({
                icon: 'ti-gift',
                message: "Welcome to <b>Paper Dashboard</b> - a beautiful Bootstrap freebie for your next project."

            },{
                type: 'success',
                timer: 4000
            });

        });
        
        function myFunction(){ 
			document.getElementById("doctor_sex").value="${ selected.sex }";
		} 
		myFunction();
		
    </script>

</body>
</html>