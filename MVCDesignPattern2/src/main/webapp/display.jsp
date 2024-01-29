<%@page import="java.util.ArrayList"%>
<%@page import="Model.DTOClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" rules="all">
<tr>
<th>EMP ID</th>
<th>EMP Name</th>
<th>EMP SAL</th> 
</tr>
<% ArrayList<DTOClass> data=(ArrayList<DTOClass>) request.getAttribute("Result");%> 
<% for(DTOClass temp:data){ %>

<tr>
<td><%=temp.getId() %></td>
<td><%=temp.getName() %></td>
<td><%=temp.getSal() %></td>
</tr>
<%}%>
</table>
</body>
</html>