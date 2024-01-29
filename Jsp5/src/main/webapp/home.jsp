<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <% %>=this is Scriptlet element which is used for to write a java code inside a jsp file --%>
<% 
int a=Integer.parseInt(request.getParameter("n1"));
int b=Integer.parseInt(request.getParameter("n2"));
int result=a+b;
%>

<%-- <%=  %>=this is Expression element which is used for to print directly--%>
<h1>Addition Is :<%= result%></h1>
</body>
</html>