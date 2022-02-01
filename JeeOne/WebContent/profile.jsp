<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="bean.*"%>
<%
	UserBean user = (UserBean) request.getSession().getAttribute("info");
CvBean profile = (CvBean) request.getSession().getAttribute("cvprofile");
	String currentUser = "unknown" ;
	if(user == null){
		System.out.println("no session");
		response.sendRedirect("/JeeOne");
	}else{
		System.out.println("session found ");
		currentUser = user.getFirstname();	
	}
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>CV</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Cemre Tellioğlu Tunçay">

<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Righteous&display=swap&subset=latin-ext"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">
<!-- Place favicon.ico in the root directory -->
<link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" />
<link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
<link rel="stylesheet" href="assets/profil.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/animate.css">
<link rel="stylesheet" href="assets/css/responsive.css">

<script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>


<body>
	<header class="top">
		<div class="fixedArea">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12 noPadding">
					<div class="content-wrapper one">
						<!-- Main Menu Start -->
						<!-- Navbar-->
						<header class="header">
							<nav class="navbar navbar-default myNavBar">
								<div class="container">

									<!-- Brand and toggle get grouped for better mobile display -->
									<div class="navbar-header">
										<div class="row">
											<div class="col-md-9 col-sm-9 col-xs-9">
												<div class="row">
													<div class="col-md-3 col-xs-3 col-sm-3">
														<a style="padding-top: 0px;"
															class="navbar-brand navBrandText text-uppercase font-weight-bold"
															href="index.html"><img src="work1.svg" alt="LOGO" /></a>

													</div>
													<div class="col-md-9 col-sm-9 col-xs-9">
														<a href="index.html"></a>

													</div>
												</div>


											</div>
											<div class="col-md-3 col-sm-3 col-xs-3">
												<button type="button" class="navbar-toggle collapsed"
													data-toggle="collapse"
													data-target="#bs-example-navbar-collapse-1"
													aria-expanded="false">
													<span class="sr-only">Toggle navigation</span> <span
														class="icon-bar"></span> <span class="icon-bar"></span> <span
														class="icon-bar"></span>
												</button>
											</div>
										</div>

									</div>

									<!-- Collect the nav links, forms, and other content for toggling -->
									<div class="collapse navbar-collapse"
										id="bs-example-navbar-collapse-1">
										<ul class="nav navbar-nav navbar-right navBar">
											<li class="nav-item"><a href="#section0"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Home
													<span class="sr-only">(current)</span>
											</a></li>
											<li class="nav-item"><a href="freelancers.html"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Find
													job</a></li>


											<li class="nav-item"><a href="register.html"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">log
													out</a></li>
										</ul>
									</div>
								</div>
							</nav>
						</header>
						<!-- Main Menu End -->
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="wrapper">
		<div class="left">
			<img src="user.png" alt="" width="100">
			<h4><c:out value="${cvprofile.firstname}" /><c:out value="${cvprofile.lastname}" /></h4>
			<p>FreeLancer </p>
		</div>
		<div class="right">
			<div class="info">
				<h3>Information</h3>
				<div class="info_data">
					<div class="data">
						<h4>First Name</h4>
						<p><c:out value="${cvprofile.firstname}" /></p>
					</div>
					<div class="data">
						<h4>Last Name</h4>
						<p><c:out value="${cvprofile.lastname}" /></p>
					</div>
					<div class="data">
						<h4>Email</h4>
						<p><c:out value="${cvprofile.email}" /></p>
					</div>
				</div>
			</div>
			<div class="info">
				<h3>CV</h3>
				<div class="info_data">
					<div class="data">
						<h4>Categorie</h4>
						<p><c:out value="${cvprofile.cv_category}" /></p>
					</div>
					<div class="data">
						<h4>langue</h4>
						<p><c:out value="${cvprofile.cv_language}" /></p>
						
					</div>
				</div>
				<div class="info_data">
					<div class="data">
						<h4>My Skills</h4>
						<c:set var="skills" value="${fn:split(cvprofile.cv_skills, '.')}" />
						<c:forEach var="skill" items="${skills}">
						<p>
							
								<c:out value="${skill}"/>&nbsp&nbsp
						</p>
						</c:forEach>
					</div>
					<div class="data">
						<h4>Hobbies</h4>
						<p><c:out value="${cvprofile.cv_hobbies}" /></p>
					</div>

				</div>
					
				<div class="info">
				
				<div class="info_data">
						<div class="data-description">
							<h4>Title</h4>
							<p><c:out value="${cvprofile.cv_title}" />
							</p>
						</div>
					</div>
					<div class="info_data">
						<div class="data-description">
							<h4>Description</h4>
							<p><c:out value="${cvprofile.cv_description}" /></p>
						</div>
					</div>
				</div>
				<div class="projects">
					<h3>Projects</h3>
					<div class="projects_data">
						<div class="data">
							<h4>Project Title</h4>
							<p><c:out value="${cvprofile.cv_project_title}" /></p>
						</div>
						<div class="data">
							<h4>Project URL</h4>
							<p><a href=<c:out value="${cvprofile.cv_project_url}"/>><c:out value="${cvprofile.cv_project_url}" /></a></p>
						</div>

					</div>
				</div>
			</div>
		</div>
</body>