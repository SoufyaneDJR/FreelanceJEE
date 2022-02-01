<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="bean.*"%>
<%@ page
	import="org.ocpsoft.prettytime.*,java.util.*,java.text.SimpleDateFormat"%>
<%


UserBean user = (UserBean) request.getSession().getAttribute("info");
if (user == null) {
	System.out.println("No session");
	response.sendRedirect("/JeeOne");

} else {
	String status = user.getStatus();
	if (status == "freelancer") {
		System.out.println(" Freelancer : Access Approved");
		String firstname = user.getFirstname();
	}
	;

	if (status == "employer") {
		System.out.println(" Employer : Access denied");
		response.sendRedirect("/JeeOne/joblist");
	}
	;

}
%>

<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Search Page</title>
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
<link rel="stylesheet" href="assets/searchpage.css">
<script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>

</head>
<body>
	<a href="/JeeOne/fillyourcv">Profile</a>
	<div class="search-box">
	<form action="/JeeOne/search" method="post">
		<input class="search-txt" type="text" name="search"
			placeholder="Type to search"> <a class="search-btn"><i
			class="fas fa-search"></i></a>
	</form>
	</div>
	
	<c:forEach var="job" items="${listJobs}">
		<div class="post">
			<div class="blog-post__info">
				<div class="postDate">
					<span><c:out value="${job.job_date}" /></span>
					<span><c:out value="${job.job_budget}" /></span>
				</div>
				<div>
					<h1 class="postTitle"><c:out value="${job.job_title}" /></h1>
					<p class="postText"><c:out value="${job.job_description}" /></p>
					<a href="search?do=read&job_id=<c:out value='${job.job_id}'/>" class="postMore" >ReadMore</a>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>