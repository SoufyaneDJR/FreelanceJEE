<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Freelance</title>
<meta charset="utf-8">
<link rel="stylesheet" href="assets/newjob.css">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
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
															href="index.html"><img src="" alt="LOGO" /></a>

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
											<li class="nav-item"><a href="#section1"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Offers</a></li>
											<li class="nav-item"><a href="#section2"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">About</a></li>
											<li class="nav-item"><a href="#section3"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Work</a></li>


											<li class="nav-item"><a href="#section6"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Contact</a></li>

											<li class="nav-item"><a href="register.html"
												class="nav-link text-uppercase font-weight-bold js-scroll-trigger">Sign
													up</a></li>



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
		<form action="joblist?do=insert" method="POST">
			<div class="row">
				<h4>Headline</h4>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="write a headline for your project"
						name="headline" />
					<div class="input-icon">
						<i class="fa fa-files-o"></i>
					</div>
				</div>
				<h4>Describe your job</h4>
				<h6>This is how talent figures out what you need and why you’re
					great to work with!</h6>
				<div class="input-group input-group-icon">
					<textarea name="jobdescription" rows="2" cols="25"
						placeholder="Already have a job description? Paste it here!"></textarea>
					<div class="input-icon">
						<i class="fa fa-wpforms"></i>
					</div>
				</div>

			</div>
			<div class="row">
				<h1>Skills</h1>
				<div class="col-half">
					<h4>Category</h4>

					<div class="col-third">
						<select name="category" id="selectCategory">
							<option disabled value selected>Which category your work
								belong</option>
							<!-- <option value="1">Customer Service</option> -->
							<option value="Data Science & Analytics">Data Science &
								Analytics</option>
							<!-- <option value="3">Design & Creative</option> -->
							<!-- <option value="4">IT & Networking</option>
                <option value="5">Sales & Marketing</option> -->
							<option value="Web, Mobile & Software Dev">Web, Mobile &
								Software Dev</option>
							<!-- <option value="7">Engineering & Architecture</option>
                <option value="8">Legal</option>
                <option value="9">Admin Support</option> -->
						</select>
					</div>
				</div>
				<div class="col-half">
					<h4>skills</h4>
					<div class="input-group">
						<div id="skillsSelect"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<h1>Scope</h1>
				<div class="col-half">

					<h4>Size</h4>

					<div class="col-third">
						<select name="size">
							<option disabled value selected>Select size of your
								project</option>
							<option value="Small">Small</option>
							<option value="Medium">Medium</option>
							<option value="Large">Large</option>


						</select>
					</div>
				</div>
				<div class="col-half">
					<h4>Time</h4>
					<div class="input-group">
						<select name="lenght">
							<option disabled value selected>How long will your work
								take ?</option>
							<option value="less than 1 month">Less than 1 month</option>
							<option value="1 to 3 months">1 to 3 months</option>
							<option value="3 to 6 months">3 to 6 months</option>
							<option value="More than 6 months">More than 6 months</option>
						</select>
					</div>
				</div>
				<div class="col-half">
					<h4>Level</h4>
					<div class="input-group">
						<select name="experience">
							<option value="">what level of experience will it need</option>
							<option value="Entry">Entry</option>
							<option value="Intermediate">Intermediate</option>
							<option value="Expert">Expert</option>

						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<h4>Budget</h4>
				<h6>Maximum project budget (DH)</h6>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Enter your budget" name="budget" />
					<div class="input-icon">
						<i class="fa fa-money"></i>
					</div>
				</div>
			</div>
			<input type="submit" class="button" value="Post your job ">
		</form>
	</div>

</body>
<script>
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
        skillsSelect +="<div><input type='checkbox' id ="+val.skill_name+" name='skill_id' value="+val.skill_name+"><label for=" + val.skill_name+">"+val.skill_name+"</label></div>";
    });
    $('#skillsSelect').html(skillsSelect);
});
}
}, false);
</script>
</html>