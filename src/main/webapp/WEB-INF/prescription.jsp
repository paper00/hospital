<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,hfut.se.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="../assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title></title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="../assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="../assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="../assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                                                       医生
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="listprescription.do">
                        <i class="ti-panel"></i>
                        <p>处方信息</p>
                    </a>
                </li>
                
                <li>
                    <a href="patientInfo.do">
                        <i class="ti-view-list-alt"></i>
                        <p>病人信息</p>
                    </a>
                </li>
                <li>
                    <a href="Doctor.do">
                        <i class="ti-user"></i>
                        <p>个人信息</p>
                    </a>
                </li>
                <li>
                    <a href="ectionInfo.do">
                        <i class="ti-text"></i>
                        <p>科室信息</p>
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
                    <a class="navbar-brand" href="#">处方信息</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>Stats</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>通知</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
						<li>
                            <a href="#">
								<i class="ti-settings"></i>
								<p>设置</p>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>

                    <div class="col-md-12">
                        <div class="card card-plain">   
                              <form id="add_prescription" method="post" action="addPrescription.do">
                            
                                <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>卡号</label>
                                                <input type="text" class="form-control border-input" placeholder="cardid" id="cardid" name="cardid" >
                                            </div>
                                        </div>
                                         <div class="col-md-3">
                                            <div class="form-group">
                                                <label>药品编号</label>
                                                <input type="text" class="form-control border-input" placeholder="med_id" id="med_id" name="med_id">
                                            </div>
                                        </div>   
                                          <div class="col-md-3">
                                            <div class="form-group">
                                                <label>药品数量</label>
                                                <input type="text" class="form-control border-input" placeholder="number" id="number" name="number">
                                            </div>
                                        </div>  
                                                                                 
                                    </div>  
                                    <div class="row">
                                       <div class="text-center">
                                         <button type="submit" class="btn btn-info btn-fill btn-wd">添加处方</button>
                                       </div>  
                                    </div>         
                                    <div class="clearfix"></div>
                                    
                                    
                                      <div class="content table-responsive table-full-width">
                                <table class="table table-hover">
                                    <thead>
                                        <th>ID</th>
                                        <th>卡号</th>
                                    	<th>药品编号</th>
                                    	<th>数量</th>
                                    	<th>日期</th>
                                    	<th>工号</th>   
                                    	<th>操作</th>                                	
                                   </thead>
                                <tbody>
                               <c:forEach items="${prescriptions}" var="p" >
							   <tr>
								<td>${p.id}</td>
								<td>${p.cardid}</td>
								<td>${p.med_id}</td>
								<td>${p.number}</td>	
								<td>${p.date}</td>
								<td>${p.did}</td>
								<td>
									<a href="delPrescription.do?id=${p.id}">删除</a>&nbsp;
								</td>
							 </tr>
							
						     </c:forEach>
                               </tbody>
                              </table>  
                              </div>
                            </form>    
                          
                         
                    
                            </div>
                        </div>
                    </div>


                </div>
   

</body>

    <!--   Core JS Files   -->
    <script src="../assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="../assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="../assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <!---<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--->

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="../assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="../assets/js/demo.js"></script>


</html>

