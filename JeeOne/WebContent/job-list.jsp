<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>my posts</title>
<meta charset="utf-8">
<link rel="stylesheet" href="assets/myPosts.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/animate.css">
<link rel="stylesheet" href="assets/css/responsive.css">

<title>Freelance</title>
<meta charset="utf-8">
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
															href="<%=request.getContextPath()%>"><img
															src="work1.svg" alt="LOGO" /></a>
													</div>
													<div class="col-md-9 col-sm-9 col-xs-9">
														<a href="<%=request.getContextPath()%>"></a>
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
											<li class="nav-item"><a
												href="<%=request.getContextPath()%>"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Home
													<span class="sr-only">(current)</span>
											</a></li>
											<li class="nav-item"><a
												href="<%=request.getContextPath()%>/joblist"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">My
													Posts</a></li>
											<li class="nav-item"><a href="#section2"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Offers</a></li>
											<li class="nav-item"><a
												href="<%=request.getContextPath()%>/chat.jsp"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Chat</a></li>
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
	<div class="container1">
		<h2>
			Your Postings <small></small>
		</h2>

		<h1>
			<a href="new-job.jsp" class="btn btn-success">Add New Job</a>
		</h1>
		<ul class="responsive-table">
			<li class="table-header">
				<div class="col col-1">Id</div>
				<div class="col col-2">Headline</div>
				<div class="col col-3">Description</div>
				<div class="col col-4">skills</div>
				<div class="col col-5">Category</div>
				<div class="col col-6">budget</div>
				<div class="col col-7">Status</div>
			</li>
			<c:forEach var="job" items="${listJobs}">
				<li class="table-row">
					<div class="col col-1" data-label="Job Id">
						<c:out value="${job.job_id}" />
					</div>
					<div class="col col-2" data-label="Customer Name">
						<p>
							<c:out value="${job.job_title}" />
						</p>
					</div>
					<div class="col col-3" data-label="Amount">
						<p>
							<c:out value="${job.job_description}" />
						</p>
					</div>
					<div class="col col-4" data-label="Payment Status">

						<c:set var="skills" value="${fn:split(job.job_skills, '.')}" />
						<p>
							<c:forEach var="skill" items="${skills}">
								<c:out value="${skill}" />&nbsp&nbsp
							</c:forEach>
						</p>
	</div>
	<div class="col col-5" data-label="Payment Status">
		<p>
			<c:out value="${job.job_category}" />
		</p>
	</div>
	<div class="col col-6" data-label="Amount">
		<p>
			<c:out value="${job.job_budget}" />
		</p>
	</div>
	<div class="col col-7" data-label="status">

		<%-- <button class="edit">
			<a href="joblist?do=edit&job_id=<c:out value='${job.job_id}' />">Edit</a>
		</button> --%>
		
		<button class="delete">
			<a href="joblist?do=delete&job_id=<c:out value='${job.job_id}' />">Delete</a>
		</button>
		<button class="edit">
			<a href="joblist?do=check&job_id=<c:out value='${job.job_id}'/>">Check Proposal</a>
		</button>
	</div>
	</li>
	</c:forEach>
	</ul>
	</div>

</body>
</html>

