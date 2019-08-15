<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Patient</title>
    
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
                <li>
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
                <li class="active">
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
                    <div class="row">
                    	<div class="col-md-6">
                    		<form action="searchpatient_0.do" method="post">
		                    	<div class="form-group" style="margin-left:17px; margin-top:16px;">
		                    		<div class="col-md-4">
				                        <input class="form-control border-input" type="date" name="begin" value="">
		                    		</div>
		                    		<div class="col-md-4">
				                        <input class="form-control border-input" type="date" name="end" value="">
		                    		</div>
			                        <button type="submit" class="btn btn-fill btn-info">查询</button>
			                        <c:if test="${ not empty operate_error_0 }">
			                        	<span style="font-size: 17px; color: red;"> ${ operate_error_0 } </span>
			                        </c:if>
		                        </div>
		                    </form>
                    	</div>
                    	
                    	<div class="col-md-6">
                    		<form action="searchpatient_1.do" method="post">
		                    	<div class="form-group" style="margin-left:17px">
		                    		<div class="col-md-5">
		                    			<input type="text" class="form-control border-input" placeholder="Card ID" name="cardid" value=""/>
		                    		</div>
		                    		<div class="col-md-3">
			                        <button type="submit" class="btn btn-fill btn-info">查询</button>
		                    		</div>
			                        <c:if test="${ not empty operate_error_1 }">
			                        	<span style="font-size: 17px; color: red;"> ${ operate_error_1 } </span>
			                        </c:if>
		                        </div>
		                    </form>
                    	</div>	
                    </div>
                    
                    <div class="col-md-12" style="margin-top:30px">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Patient Table</h4>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                        <th>卡号</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>手机</th>
                                    </tr></thead>
                                    <tbody>
                                    	<c:if test="${ not empty patients }"> 
	                                        <c:forEach var="patient" items="${ patients }" varStatus="i">
	                                            <tr class="row${ i.index%2 + 1 }">
	                                                <td> ${ patient.cardid }</td>
	                                                <td> ${ patient.name } </td>
	                                                <td> ${ patient.sex } </td>
	                                                <td> ${ patient.phone } </td>
	                                            </tr>
	                                        </c:forEach>
										</c:if>
										<c:if test="${ not empty patient }">
											<tr class="row1">
												<td> ${ patient.cardid }</td>
                                                <td> ${ patient.name } </td>
                                                <td> ${ patient.sex } </td>
                                                <td> ${ patient.phone } </td>
                                            </tr>
										</c:if>
                                    </tbody>
                                </table>

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
                            <a href="#">
                                Creative Tim
                            </a>
                        </li>
                        <li>
                            <a href="http://blog.creative-tim.com">
                               Blog
                            </a>
                        </li>
                        <li>
                            <a href="#/license">
                                Licenses
                            </a>
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
    </script>

</body>
</html>