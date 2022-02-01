<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Proposals</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Cemre Tellioğlu Tunçay">

    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Righteous&display=swap&subset=latin-ext" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!-- Place favicon.ico in the root directory -->
    <link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" />
    <link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
    <link rel="stylesheet" href="assets/searchpage.css">
    <script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script></head>

<body>
	<h1>Title : <c:out value="${jobinfo.job_title}" /></h1>
	<h4>Description :</h4><p><c:out value="${jobinfo.job_description}" /></p>
	
    <c:forEach var="proposal" items="${proposals}">
		<div class="post">
			<div class="blog-post__info">
				<div class="postDate">
					<span><c:out value="${proposal.proposal_date}" /></span>
				</div>
				<div>
					<c:forEach var="freelancer" items="${freelancers}">
					<c:if test="${freelancer.user_id.equals(proposal.freelancer_id)}">
					<p class="postText">
					Freelancer :<a href="/JeeOne/fillyourcv?user=${freelancer.user_id}"><c:out value="${freelancer.firstname}" /> <c:out value="${freelancer.lastname}" /></a>
					</p>
					</c:if>
					
					</c:forEach>
					<p class="postText"><c:out value="${proposal.job_coverletter}" /></p>
					<a href="/chat.jsp" class="postMore" >Send a Message</a>
				</div>
			</div>
		</div>
	</c:forEach>
</body>