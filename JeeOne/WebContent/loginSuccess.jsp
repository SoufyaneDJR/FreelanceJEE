<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="bean.LoginBean" %>
<!DOCTYPE html>
<% LoginBean log = new LoginBean();
  log = (LoginBean)session.getAttribute("info") ;%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align ="center">
<% if (log != null ) {%>

<h1>you have login Successfully</h1>
<%= log.getEmail() %>
<%}; %>
</div>
</body>
</html>
