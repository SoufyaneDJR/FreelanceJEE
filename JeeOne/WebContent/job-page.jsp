<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="bean.*"%>
<%
	UserBean user = (UserBean) request.getSession().getAttribute("info");
	int currentUser ;
	if(user == null){
		System.out.println("no session");
		response.sendRedirect("/JeeOne");
	}else{
		System.out.println("session found ");
		currentUser = user.getUser_id();	
	}
	
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title><c:out value="${selectedjob.job_title}" /></title>
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
<link rel="icon" type="image/png" href="assets/img/favicon-32x32.png"
	sizes="32x32" />
<link rel="icon" type="image/png" href="assets/img/favicon-16x16.png"
	sizes="16x16" />
<link rel="stylesheet" href="assets/job-page.css">

<script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>

</head>
<body>
	<div class="postInfo">
		<div>
			<h1 class="postTitle">
				<c:out value="${selectedjob.job_title}" />
			</h1>
		</div>
		<div>
			<h4 class="postCategory">
				<c:out value="${selectedjob.job_category}" />
			</h4>
			<h6 class="postCategory">Posted 21 hours ago</h6>
		</div>
		<div>
			<p class="postText">
				<c:out value="${selectedjob.job_description}" />
			</p>
		</div>
		<div class="details_post">
			<p class="postBudget">
				<c:out value="${selectedjob.job_budget}" /> Dhs
				<span>Fixed-price</span>
			</p>
			<p class="postLevel">
				<c:out value="${selectedjob.job_experience}" />
				<c:choose>
					<c:when test="${selectedjob.job_experience =='Entry'}">
						<span>I am looking for freelancers with the lowest rates</span>
					</c:when>
					<c:when test="${selectedjob.job_experience =='Intermediate'}">
						<span>I am looking for a mix of experience and value</span>
					</c:when>
					<c:when test="${selectedjob.job_experience =='Expert'}">
						<span>I am willing to pay higher rates for the most experienced freelancers</span>
					</c:when>
				</c:choose>
				
			</p>
			<p class="postSkills">
				Skills and Expertise
				<c:set var="skills" value="${fn:split(selectedjob.job_skills, '.')}" />
						<c:forEach var="skill" items="${skills}">
						<span>
								<c:out value="${skill}"/>&nbsp&nbsp
						</span>
						</c:forEach>
			</p>
		</div>
		<div>
			<p class="postSkills"></p>
		</div>

		<form action="/JeeOne/proposals?do=submit&job_id=${selectedjob.job_id}&employer_id=${selectedjob.user_id}" method="post">
			<div>
				<h4>What is the rate you'd like to bid for this job?</h4>
				<div class="infoProject">
					<input type="text" name="job_bid">
				</div>

				<div class="infoProject">
					<h4>Cover Letter</h4>
					<textarea name="job_coverletter" rows="4" cols="72"  
						placeholder="Add more informations to your proposal ..."></textarea>
				</div>
			</div>
			<input type="submit" class="postMore" value="submit">
		</form>


	</div>


</body>
</html>