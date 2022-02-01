<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Freelance</title>
      <meta charset="utf-8">
      <link rel="stylesheet" href="assets/signin.css">
    </head>
    <body>
      <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign up </h2>
    

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="imgpng.png" id="icon" alt="User Icon" />
    </div>
    <form action="register" method="post" autocomplete="off">
      <input type="text" class="fadeIn third" name="email" placeholder="email">
      <input type="text"  class="fadeIn second" name="firstname" placeholder="firstname">
      <input type="text"  class="fadeIn third" name="lastname" placeholder="lastname">
      <input type="password" class="fadeIn fourth" name="password" placeholder="password">
      <div class="fadeIn fifth">
        <input type="radio" name="status" id="freelancer" value="freelancer">
        <label for="freelancer">Work as a freelancer</label>
        <input type="radio" name="status" id ="employer" value = "employer">
        <label for="employer">Hire for a project</label>
      </div>  
      <input type="submit" class="fadeIn sixth" value="Create your account">
    </form>
    <div id="formFooter">
      <a class="underlineHover" href="/JeeOne">already have an account?</a>
    
    </div>
   

  </div>
</div>

    </body>
</html>

    