<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <title>Freelance</title>
    <meta charset="utf-8">
    <%@ include file="include/css.jsp" %>
  </head>

  <body>
    <div class="wrapper fadeInDown">
      <div id="formContent">

        <h2 class="active"> Log in </h2>



        <div class="fadeIn first">
          <img src="imgpng.png" id="icon" alt="User Icon" />
        </div>

        <form action="login" method="post">
          <input type="text" class="fadeIn second" name="email" placeholder="email">
          <input type="password" class="fadeIn third" name="password" placeholder="password">
          <input type="submit" class="fadeIn fourth" value="submit">
        </form>
        <div id="formFooter">
          <a class="underlineHover" href="#">Forgot Password</a>
        </div>
        <div id="formFooter">
          <a class="underlineHover" href="register.jsp">Sign up</a>
        </div>

      </div>
    </div>

  </body>

  </html>