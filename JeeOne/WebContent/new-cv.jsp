<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*"%>
<%
	UserBean user = (UserBean) request.getSession().getAttribute("info");
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

<link
	href="https://fonts.googleapis.com/css?family=Roboto&amp;display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Righteous&amp;display=swap&amp;subset=latin-ext"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&amp;display=swap"
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

<script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"
	type="text/javascript"></script>
<script src="js/vendor/modernizr-2.8.3.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/b99e675b6e.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	type="text/javascript"></script>

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
	<form action="/JeeOne/fillyourcv?do=insert" method="post">
		<div class="wrapper">
			<div class="left">
				<img src="user.png" alt="user" width="100">
				<h4><%=user.getFirstname() %> <%=user.getLastname() %></h4>
				<p><%=user.getStatus() %></p>
			</div>
			<div class="right">
				<div class="info">
					<h3>Information</h3>
					<div class="info_data">
						<div class="data">
							<h4>First Name</h4>
							<p><%=user.getFirstname() %></p>
						</div>
						<div class="data">
							<h4>Last Name</h4>
							<p><%=user.getLastname() %></p>
						</div>
						<div class="data">
							<h4>Email</h4>
							<p><%=user.getEmail() %></p>
						</div>
					</div>
				</div>
				<div class="info">
					<h3>CV</h3>
					<div class="info">
						<div class="cv">
							<div class="infoProject">
								<label style="margin-bottom: 15px;">Category :</label> 
								<select name="cv_category" id="selectCategory">
									<option disabled value selected>Which category your
										work belong</option>
									<option value="Data Science &amp; Analytics">Data
										Science & Analytics</option>
									<option value="Web, Mobile &amp; Software Dev">Web,
										Mobile & Software Dev</option>
								</select>
							</div>

							<div class="infoProject">
								<label style="margin-bottom: 15px;">Language :</label> 
								<select name="cv_language">
									<option name="cv_language" value="Arabe" >Arabe</option>
									<option name="cv_language" value="English">English</option>
									<option name="cv_language" value="Francais">Francais</option>
								</select>
							</div>
						</div>
						<div>
							<label>skills</label>
							<div class="input-group">
								<div class="skillsSelected" id="skillsSelect" style="padding-bottom:5px;"></div>
							</div>

							<div class="infoProject"
								style="margin-left: 65px; margin-top: -20px">
								<label>Title</label> <input type="text" name="cv_title">
							</div>
							<label style="padding:5px;">Write about yourself here !</label>
							<textarea name="cv_description" rows="7" cols="42"  
						placeholder="Already have a job description? Paste it here!"></textarea>
						</div>
						<div class="projects">
							<h3 style="padding-top:15px;">Projects</h3>
							<div>
								<div class="infoProject"
									style="margin-left: 59px; margin-bottom: -20px">
									<label>Project Title</label> <input type="text" name="cv_project_title">
								</div>

								<div class="infoProject"
									style="margin-left: 65px; margin-top: -20px">
									<label>Project URL</label> <input type="text" name="cv_project_url">
								</div>
							</div>
							<input type="submit" class="button" value="Submit Your CV">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
document.addEventListener('input', function (event) {
id = 0;
if (event.target.id !== 'selectCategory') {return;} else {
value = event.target.value;
if (value ==="Web, Mobile & Software Dev") {
	id = 6;
} 
if (value ==="Data Science & Analytics"){
	id = 2;
}

data = [
	{
		"skill_id" : 1,
		"category_id" : 6,
		"skill_name" : "JavaScript"
	},
	{
		"skill_id" : 2,
		"category_id" : 6,
		"skill_name" : "HTML5"
	},
	{
		"skill_id" : 3,
		"category_id" : 6,
		"skill_name" : "Web Programming"
	},
	{
		"skill_id" : 4,
		"category_id" : 6,
		"skill_name" : "CSS 3"
	},
	{
		"skill_id" : 5,
		"category_id" : 6,
		"skill_name" : "Web Design"
	},
	{
		"skill_id" : 6,
		"category_id" : 6,
		"skill_name" : "Website"
	},
	{
		"skill_id" : 7,
		"category_id" : 6,
		"skill_name" : "Bootstrap"
	},
	{
		"skill_id" : 8,
		"category_id" : 6,
		"skill_name" : "Web Application"
	},
	{
		"skill_id" : 9,
		"category_id" : 6,
		"skill_name" : "GraphQL"
	},
	{
		"skill_id" : 10,
		"category_id" : 6,
		"skill_name" : "PHP"
	},
	{
		"skill_id" : 11,
		"category_id" : 6,
		"skill_name" : "Node.js"
	},
	{
		"skill_id" : 12,
		"category_id" : 6,
		"skill_name" : "Redux"
	},
	{
		"skill_id" : 13,
		"category_id" : 6,
		"skill_name" : "AngularJS"
	},
	{
		"skill_id" : 14,
		"category_id" : 6,
		"skill_name" : "SCSS"
	},
	{
		"skill_id" : 15,
		"category_id" : 6,
		"skill_name" : "Gatsby.js"
	},
	{
		"skill_id" : 16,
		"category_id" : 6,
		"skill_name" : "Sass"
	},
	{
		"skill_id" : 17,
		"category_id" : 6,
		"skill_name" : "Vue.js"
	},
	{
		"skill_id" : 18,
		"category_id" : 6,
		"skill_name" : "MySQL"
	},
	{
		"skill_id" : 19,
		"category_id" : 6,
		"skill_name" : "API"
	},
	{
		"skill_id" : 20,
		"category_id" : 6,
		"skill_name" : "React Native"
	},
	{
		"skill_id" : 30,
		"category_id" : 2,
		"skill_name" : "Data Access Layer"
	},
	{
		"skill_id" : 31,
		"category_id" : 2,
		"skill_name" : "Data Analysis"
	},
	{
		"skill_id" : 32,
		"category_id" : 2,
		"skill_name" : "Data Analytics"
	},
	{
		"skill_id" : 33,
		"category_id" : 2,
		"skill_name" : "Data Annotation"
	},
	{
		"skill_id" : 34,
		"category_id" : 2,
		"skill_name" : "Data Backup"
	},
	{
		"skill_id" : 35,
		"category_id" : 2,
		"skill_name" : "Data Center Design"
	},
	{
		"skill_id" : 36,
		"category_id" : 2,
		"skill_name" : "Data Center Migration"
	},
	{
		"skill_id" : 37,
		"category_id" : 2,
		"skill_name" : "Data Center Operations"
	},
	{
		"skill_id" : 38,
		"category_id" : 2,
		"skill_name" : "Data Cleansing"
	},
	{
		"skill_id" : 39,
		"category_id" : 2,
		"skill_name" : "Data Collection"
	}
]
console.log(id);
filtered = data.filter(({category_id}) => category_id === id);
$(document).ready(function() {
    var skillsSelect="";
    jQuery.each(filtered, function(i, val) {
        skillsSelect +="<div style='padding:5px 10px;'><input type='checkbox' id ="+val.skill_name+" name='cv_skills' value="+val.skill_name+"><label for=" + val.skill_name+">"+val.skill_name+"</label></div>";
    });
    $('#skillsSelect').html(skillsSelect);
});
}
}, false);
</script>
</body>
</html>